package okjiaoyu.qa.middle.auto.testcase.parentApp.student;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.parentApp.CommonUtils;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.Pa_login_parent;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import okjiaoyu.qa.tools.*;
import okjiaoyu.qa.tools.handler.JsonpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shenbingbing on 2019/02/18.
 */
public class ParentApp_student extends TestBase {

    public static String account_uname = "";
    public static String account_pwd = "";
    public static String account_uid = "";
    public static String account_token = "";
    public static String account_account = "";
    public static JSONObject account_commonUp = new JSONObject();
    public static String[] pics;
    public String requestMethod = "test";

    public void setCommonUp() {
        logger.info("[method]: setCommonUp start ----------");
        account_commonUp.put("imsi", "");
        account_commonUp.put("vc", "2911");
        account_commonUp.put("mac", "");
        account_commonUp.put("channel", "okay");
        account_commonUp.put("serial", "92A3D1B3-C0CE-44B3-BF36-B324EDFD7C31");
        account_commonUp.put("os", "ios");
        account_commonUp.put("vn", "2.9.0.5");
        account_commonUp.put("vs", "11.2.6");
        account_commonUp.put("sh", "2208");
        account_commonUp.put("imei", "");
        account_commonUp.put("contype", "0");
        account_commonUp.put("ua", "iPhone6Plus(A1522/A1524)_11.2.6");
        account_commonUp.put("sw", "1242");
        account_commonUp.put("udid", "062838CA-5B44-494A-823B-38025403292C");
        logger.info("[method]: setCommonUp end ----------");
    }

    //设置账户
    public void setAccount(String type) {
        logger.info("[method]: setAccount start ----------");
        try {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            if("test".equals( type )){
                account_uname = getPropertiesData.getData("loginUser");
                account_pwd = getPropertiesData.getData("password");
            }else if("exceptionTest".equals( type )){
                account_uname = getPropertiesData.getData("loginUserException");
                account_pwd = getPropertiesData.getData("passwordException");
            }

//            if(RunningParameter.env.equals("test")){
//                account_uname = Config.getModuleConfig("test-loginUser");
//                account_pwd = Config.getModuleConfig("test-password");
//            }else if(RunningParameter.env.equals("online")){
//                account_uname = Config.getModuleConfig("online-loginUser");
//                account_pwd = Config.getModuleConfig("online-password");
//            }else if(RunningParameter.env.equals("hotfix")){
//                account_uname = Config.getModuleConfig("hotfix-loginUser");
//                account_pwd = Config.getModuleConfig("hotfix-password");
//            }
            RunningParameter.uname = account_uname;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("occur a problem during setAccount!");
        }

        logger.info("[method]: setAccount end ----------");
    }

    public void getTokenValue(String tokenValue, JSONObject json) {
        if (!tokenValue.equals("miss")) {
            if (tokenValue.equals("newest")) {
                json.put("token", ParentApp_parent.account_token);
            } else if (tokenValue.equals("expired")) {
                String expieredToken = buildExpiredToken( ParentApp_parent.account_token);
                json.put("token", expieredToken);
            } else {
                json.put("token", tokenValue);
            }
        }
    }


    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_studentapp_normal";
        RunningParameter.monitor_projectId = 3;
        RunningParameter.projectName = "parentapp";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_studentapp_exception";
        RunningParameter.monitor_projectId = 3;
        RunningParameter.projectName = "parentapp";
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
    @BeforeTest(groups = {"normal"})
    public void startupnormal() {
        //module settings
        RunningParameter.projectName = "parentapp";
        RunningParameter.settingFilePath = "/url/parentApp/setting.xml";

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置公共上行
        setCommonUp();
        //设置用户名密码
        setAccount("test");
        //更新token
        Pa_login_parent login = new Pa_login_parent();
        login.login();
    }
    @BeforeTest(groups = {"exception"})
    public void startupexception() {
        //module settings
        RunningParameter.projectName = "parentapp";
        RunningParameter.settingFilePath = "/url/parentApp/setting.xml";

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置公共上行
        setCommonUp();
        //设置用户名密码
        setAccount("exceptionTest");
        //更新token
        Pa_login_parent login = new Pa_login_parent();
        login.login();
    }

    //发送post请求
    public void postRequest(Map<String, String> param) {
        getCaseBasicInfo(param);
        getUpData(param);
        //发送请求
        requestSampler.setResponseInfo(new APIHttpClient().executePostRequest(requestSampler.getRequestUrl(), JSONObject.parseObject(requestSampler.getRequestInfo()), requestSampler.getRequestProId()));
        logger.info("[RequestInfo]:" + requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]:" + requestSampler.getRequestInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    //发送post请求
    public void postRequestByJson(Map<String, String> param) {
        getCaseBasicInfo(param);
        getUpData(param);
        JSONObject jsonObject = JSONObject.parseObject(requestSampler.getRequestInfo());
        jsonObject.putAll(account_commonUp);
        requestSampler.setRequestInfo(JSONObject.toJSONString(jsonObject));
        requestSampler.setRequestProId("09", "");
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
        System.out.println("ispass: " + requestSampler.isPass());
        Assert.assertTrue(requestSampler.isPass());
    }

    //params for get request
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        NameValuePair collection_id = new BasicNameValuePair("collection_id", param.get("collection_id"));
        NameValuePair type = new BasicNameValuePair("type", param.get("type"));
        getRequestParms.add(collection_id);
        getRequestParms.add(type);
        //shenbingbing add 保证okay+,没用
        requestSampler.setRequestProId("09", "");
        requestSampler.setGetRequsetParams(getRequestParms);
    }
    public void getRequest(Map<String, String> param) {
        //request params
        getCaseBasicInfo(param);
        getParams(param);
        APIHttpClient apiHttpClient = new APIHttpClient();
        //send request
        apiHttpClient.getRequest(requestSampler);



        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        isSuccess(requestSampler);
    }


   //单独路径 get start
    public void getRequestUtil(Map<String, String> param) {
        getCaseBasicInfoUtil(param);
        getParams(param);
        requestSampler.setRequestProId("09", "");//添加前缀07，有助于研发排查问题;特别是token失效问题；
        new CommonUtils().getRequest(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        isSuccess(requestSampler);
    }
    public void getCaseBasicInfoUtil(Map<String, String> param) {
        //basic info
        requestSampler.setRequestUrl(getInterfaceUrlUtil());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setKeyWord(param.get("keyWord"));
        if (this.requestSampler.getType() != 2)
            logger.info(requestSampler.getInterfaceName() + " - " + requestSampler.getTestCaseName());

    }
    public String getInterfaceUrlUtil() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        return getPropertiesData.getData( "ImUrl" ) + RunningParameter.apiXml.getElementText( "//" + this.getClass().getSimpleName() );
    }
    //单独路径 get end

    //单独路径 post start
    public void postRequestByJsonUtil(Map<String, String> param) {
        getCaseBasicInfoUtil(param);
        getUpData(param);
        JSONObject jsonObject = JSONObject.parseObject(requestSampler.getRequestInfo());
        jsonObject.putAll(account_commonUp);
        requestSampler.setRequestInfo(JSONObject.toJSONString(jsonObject));
        requestSampler.setRequestProId("09", "");
        //发送请求
        new CommonUtils().executePostRequestUtil(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }
    //单独路径 post end

}
