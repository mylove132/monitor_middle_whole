package okjiaoyu.qa.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.persistance.controller.RequestHistoryController;
import okjiaoyu.qa.persistance.controller.TestHistoryController;
import okjiaoyu.qa.persistance.model.RequestHistory;
import okjiaoyu.qa.tools.*;
import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Thinkpad on 2015/4/14.
 * 测试基类
 */
public class RomTestBase {

    public Logger logger = Logger.getLogger(this.getClass());

    public RequestSampler requestSampler = new RequestSampler();

    private String objectNodeType = "o";
    private String arrayNodeType = "a";

    @DataProvider
    public Object[][] providerMethod(Method method) throws IOException {
        String path = "/data" + this.getClass().getResource("").getPath().split("testcase")[1];
        String env = RunningParameter.branch + "/";
        //测试数据配置文件
        String dataXmlFilePath = path + env + this.getClass().getSimpleName() + ".xml";
        ParseXml px = new ParseXml(dataXmlFilePath);
        String methodName = method.getName();
        List<Element> elements = px.getElementObjects("/*/" + methodName);
        Object[][] objects = new Object[elements.size()][];
        for (int i = 0; i < elements.size(); i++) {
            Object[] temp = new Object[]{px.getChildrenInfoByElement(elements.get(i))};
            objects[i] = temp;
        }
        return objects;
    }


    public void getApiXml() {
        this.logger.info("[method]: getApiXml start ----------");
        String classPath = this.getClass().getResource("").getPath();
        String folderPath = classPath.split("testcase")[1];
        String className = this.getClass().getSimpleName();
        String path = "/url" + folderPath.split(className)[0] + ".xml";
        RunningParameter.apiXmlPath = path.replace("/.xml", ".xml");
        RunningParameter.apiXml = new ParseXml(RunningParameter.apiXmlPath);
        this.logger.info("[method]: getApiXml end ----------");
    }

    public void getUrlHeader() {
//        GetPropertiesData getPropertiesData = new GetPropertiesData();
//        RunningParameter.urlHeader = getPropertiesData.getData("UrlHeader");
        RunningParameter.urlHeader = "https://sys.padapi.okjiaoyu.cn/";
        this.logger.info("[UrlHeader]: " + RunningParameter.urlHeader);
    }


    public void getEnv() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        RunningParameter.env = getPropertiesData.getData("env");
        RunningParameter.branch = getPropertiesData.getData("branch");
    }


    public String getInterfaceUrl() {
        return RunningParameter.urlHeader + RunningParameter.apiXml.getElementText("//" + this.getClass().getSimpleName());
    }

    public String getInterfaceName() {
        return RunningParameter.apiXml.getElementText("//" + this.getClass().getSimpleName() + "Name");
    }


    public void getUpData(Map<String, String> param) {
        //uniq data
        requestSampler.setRequestInfo(getRequestJsonString(param));
    }

    public void getCaseBasicInfo(Map<String, String> param) {
        //basic info
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setKeyWord(param.get("keyWord"));
        if (this.requestSampler.getType() != 2)
            logger.info(requestSampler.getInterfaceName() + " - " + requestSampler.getTestCaseName());

    }

    //获取json上行
    public String getRequestJsonString(Map<String, String> param) {
        this.logger.error("------------------  no override codes found  -----------------");
        return "";
    }

    @BeforeSuite(groups = {"normal", "exception"})
    public void createRecord() {
        RunningParameter.caseAmount = 0;
        RunningParameter.passAmount = 0;
        RunningParameter.failAmount = 0;
        logger.info("Test Suite begining ------------------------------");

        //测试开始时间
        TestReport.startTime = new Date();
        logger.info("test startTime:" + TestReport.startTime);

        RunningParameter.testHistory.setStartTime(new Date());
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        RunningParameter.testHistory.setEntityEnvId(Integer.parseInt(getPropertiesData.getData("env_id")));
        RunningParameter.testHistory.setExecutetype("monitor");
        RunningParameter.testHistory.setResult(true);
    }

    @BeforeMethod(groups = {"normal", "exception"})
    public void beforeMethodBase() {
        RunningParameter.caseAmount += 1;
        requestSampler.setStartTime(System.currentTimeMillis());
        logger.info(" ------------------------------------------ ");
        logger.info(" ------------- testcase start-------------- ");
    }

    public void isSuccess(RequestSampler requestSampler) {
        //判断测试用例是否通过
        if (requestSampler.getHttpStatus() == 200) {
            JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
            Boolean judgeRes = judgeKeyWord(responseJson, requestSampler.getKeyWord());
            requestSampler.setPass(isPass && judgeRes);
            if (isPass) {
                logger.info(requestSampler.getResultInfo());
            } else {
                TestReport.isPass = false;
                requestSampler.printRequestErrorDetail();//将请求的所有详情，打印到错误日志中
            }
        } else {//http请求失败
            TestReport.isPass = false;
            requestSampler.setPass(false);
        }
        Assert.assertEquals(requestSampler.getHttpStatus(), 200, "http请求的状态码不是200，http请求失败");
        Assert.assertTrue(requestSampler.isPass());
    }


    private Boolean judgeKeyWord(JSONObject responsJson, List<String> keyWords) {
        Boolean res = true;
        if (keyWords == null || keyWords.isEmpty()) {
            return res;
        }
        for (String keyWord : keyWords) {
            String[] nodes;
            if (keyWord.contains(".")) {
                nodes = keyWord.split(".");
            } else {
                nodes = new String[]{keyWord};
            }
            JSONObject tmpObject = responsJson;
            //遍历所有需要过滤的关键字
            for (int i = 0; i < nodes.length; i++) {
                String nodeAll = nodes[i];
                String[] all = nodeAll.split("_");
                //获取关键字中的节点类型和名称
                String type = all[0];
                String node = all[1];
                //如果包含节点则获取下一节点数据，否则返回
                if (tmpObject.containsKey(node)) {
                    //获取Object数据
                    if (objectNodeType.equals(type)) {
                        tmpObject = tmpObject.getJSONObject(node);
                        //获取Array类型数据
                    } else if (arrayNodeType.equals(type)) {
                        JSONArray tmpArray = tmpObject.getJSONArray(node);
                        //遍历JsonArray中所有节点查找指定属性，目前只支持一层数组
                        String nextNode = nodes[i + 1];
                        String[] nextNodeSplit = nextNode.split("_");
                        for (int j = 0; j < tmpArray.size(); j++) {
                            JSONObject jsonObject = tmpArray.getJSONObject(j);
                            if (!jsonObject.containsKey(nextNodeSplit[1])) {
                                res = false;
                                break;
                            }
                        }
                    }
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    @AfterMethod(groups = {"normal", "exception"})
    public void saveRequestHistory() {
        //添加响应时间
        requestSampler.setEndTime(System.currentTimeMillis());
        requestSampler.setResponseTime();
        if (requestSampler.isPass()) {
            RunningParameter.passAmount += 1;
        } else {
            RunningParameter.failAmount += 1;
        }
        logger.info(" [testcase result]:" + (requestSampler.isPass() ? "Pass" : "Fail"));
        logger.info(" ------------- testcase done--------------- ");
        logger.info(" ------------------------------------------ ");
        logger.info(" done ");

        RequestHistory requestHistory = convertSampler2History(this.requestSampler);
        RunningParameter.monitor_requestHistories.add(requestHistory);
    }

    public RequestHistory convertSampler2History(RequestSampler requestSampler) {
        RequestHistory requestHistory = new RequestHistory();
        requestHistory.setRequestid(requestSampler.getRequestId());
        requestHistory.setEntityInterfaceName(requestSampler.getInterfaceName());
        requestHistory.setEntityTestcaseName(requestSampler.getTestCaseName());
        requestHistory.setRequesturl(requestSampler.getRequestUrl());
        requestHistory.setRequestdata(getString(requestSampler.getrequestDetailInfo()));
        requestHistory.setHttpstatus(requestSampler.getHttpStatus());
        requestHistory.setResponsedata(getString(requestSampler.getResponseInfo()));
        requestHistory.setResult(requestSampler.isPass());
        requestHistory.setRequesttype("http");
        requestHistory.setResponseTime(requestSampler.getresponseTime());
        return requestHistory;
    }

    public String getString(String str) {
        String result;
        if (str == null) {
            result = "null";
        } else {
            result = str;
        }
        return result;
    }

    @AfterSuite(groups = {"normal", "exception"})
    public void saveRecord() {
        TestReport.endTime = new Date();
        logger.info("test endTime:" + TestReport.endTime);
        logger.info("@@@@@@@@@@@@@All test Completed!@@@@@@@@@@@@@@@");
        if (TestReport.isPass) {
            logger.info("Test Pass");
        } else {
            logger.error("Test Failed");
        }

        //update database
        logger.info(" ------------- begin save data to database ---------------- ");
        RunningParameter.testHistory.setTestName("regular_monitor");
        RunningParameter.testHistory.setEndTime(new Date());
        RunningParameter.testHistory.setResult(TestReport.isPass);
        RunningParameter.testHistory.setEntityProjectId(RunningParameter.monitor_projectId);
        RunningParameter.testHistory.setCaseamount(RunningParameter.caseAmount);
        RunningParameter.testHistory.setPasscaseamount(RunningParameter.passAmount);
        RunningParameter.testHistory.setFailcaseamount(RunningParameter.failAmount);
        RunningParameter.testHistory.setExecutetype("monitor");

        //insert testHistory to database
        new TestHistoryController().insert(RunningParameter.testHistory);
        new RequestHistoryController().insertMonitorRequestHistorys(RunningParameter.monitor_requestHistories, RunningParameter.testHistory.getId());
        //print
        logger.info(" ----------------- database update complete ---------------- ");
        logger.info("new test_history id is " + RunningParameter.testHistory.getId());
        logger.info("[caseAmount1]:" + RunningParameter.caseAmount);
        logger.info("[passAmount]:" + RunningParameter.passAmount);
        logger.info("[failAmount]:" + RunningParameter.failAmount);
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        boolean sendPassReport = Boolean.parseBoolean(getPropertiesData.getData("sendPassReport"));
        logger.info("sendPassReport的值为: " + sendPassReport);
//        new CaseNotice().sendnotice();
        if (sendPassReport || !RunningParameter.testHistory.getResult()) {
//        if(sendPassReport || !RunningParameter.testHistory.getResult() || RunningParameter.sendPassReport){
            new MailController().sendTestReport(RunningParameter.project_name, "fail_detail");
        }

    }

    public boolean isTestCasePass(JSONObject jsonObject, String checkeData) {
        CheckCondition checkCondition = new CheckCondition();
        boolean isPass = checkCondition.verify(jsonObject, checkeData);
        return isPass;
    }

    public void shutDown() {
        RequestHistory requestHistory = convertSampler2History(this.requestSampler);
        RunningParameter.monitor_requestHistories.add(requestHistory);

        new RomTestBase().saveRecord();
        System.exit(1);
    }

    public String buildExpiredToken(String token) {
        return token.substring(0, (token.length() - 5)) + "eeeee";
    }


    public void getKeyWord() {

    }
}
