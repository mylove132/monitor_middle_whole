package okjiaoyu.qa.middle.auto.testcase.publicweb;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.tools.*;
import okjiaoyu.qa.tools.handler.JsonpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 学校后台的基类
 */
public class PublicWeb extends TestBase {

    public static String uid = "";
    public static String pwd = "";
    public static String account_pwd_old = "";
    public static String login_type = "";
    //    public static JSONObject account_commonUp = new JSONObject();
    public String requestMethod = "test";

    //设置账户
    public void setAccount() {
        logger.info("[method]: setAccount start ----------");
        try {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            uid = getPropertiesData.getData("uid");
            pwd = getPropertiesData.getData("pwd");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("occur a problem during setAccount!");
        }

        logger.info("[method]: setAccount end ----------");
    }


    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "publicweb_normal";
        RunningParameter.monitor_projectId = 22;
        RunningParameter.projectName = "publicweb";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "publicweb_exception";
        RunningParameter.monitor_projectId = 22;
        RunningParameter.projectName = "publicweb";
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

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount();

        //登录获取cookiec
        Pw_Login pw_login = new Pw_Login();
        pw_login.login();
    }

    @BeforeTest(groups = {"normal", "exception"})
    public void startup() {
        //module settings
        RunningParameter.projectName = "publicweb";
        //RunningParameter.settingFilePath = "/url/platformresource/setting.xml";

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount();

//        //登录获取cookiec
//        Pw_Login pw_login = new Pw_Login();
//        pw_login.login();


    }

    @BeforeMethod(groups = {"normal", "exception"})
    public void beforeMethodBase() {
        RunningParameter.caseAmount += 1;
        logger.info(" ------------------------------------------ ");
        logger.info(" ------------- testcase start-------------- ");

    }

    //发送post请求
    public void postRequest(Map<String, String> param) {
        getCaseBasicInfo(param);
        getUpData(param);
        //发送请求
        APIHttpClient apiHttpClient = new APIHttpClient();
        apiHttpClient.setCookies();
        //send request
        apiHttpClient.executePostRequest(requestSampler);

        logger.info("[RequestInfo]:" + requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]:" + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    //发送post请求
    public void postRequestByJson(Map<String, String> param) {
        getCaseBasicInfo(param);
        getUpData(param);
        JSONObject jsonObject = JSONObject.parseObject(requestSampler.getRequestInfo());
//        jsonObject.putAll(account_commonUp);
        requestSampler.setRequestInfo(JSONObject.toJSONString(jsonObject));
        //发送请求
        new APIHttpClient().executePostRequest(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }


    public boolean isTestCasePass(JSONObject jsonObject, String checkeData) {
        boolean isPass;
        try {
            CheckCondition checkCondition = new CheckCondition();
            isPass = checkCondition.verify(jsonObject, checkeData);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage() + e.getMessage());
            return false;
        }
        return isPass;
    }

    public void isSuccess(RequestSampler requestSampler) {
        //判断测试用例是否通过
        if (requestSampler.getHttpStatus() == 200) {
            //判断是否通过你
            String responseJsonString = requestSampler.getResponseInfo();
            if (requestSampler.getRequestMethod() != null && requestSampler.getRequestMethod().equals("get")) {
                responseJsonString = new JsonpHandler().getJsonString(responseJsonString);
            } else {
                logger.info("this is a post request");
            }
            JSONObject responseJson = JSONObject.parseObject(responseJsonString);
            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
            requestSampler.setPass(isPass);
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

    //params for get request
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        NameValuePair collection_id = new BasicNameValuePair("collection_id", param.get("collection_id"));
        NameValuePair type = new BasicNameValuePair("type", param.get("type"));
        getRequestParms.add(collection_id);
        getRequestParms.add(type);
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    public void getRequest(Map<String, String> param) {
        //request params
        getParams(param);
        requestSampler.setRequestProId("08", "");
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        APIHttpClient apiHttpClient = new APIHttpClient();
        apiHttpClient.setCookies();

        //send request
        apiHttpClient.getRequest(requestSampler);
        logger.info("[RequestJson]: " + requestSampler.getRequestInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        isSuccess(requestSampler);
    }

}
