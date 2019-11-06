package okjiaoyu.qa.middle.auto.testcase.mall;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
//import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import okjiaoyu.qa.tools.*;
import okjiaoyu.qa.tools.handler.JsonpHandler;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

/**
 * Created by 晓 on 2015/7/11.
 */
public class Mallh5_parent extends TestBase {

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
        account_commonUp.put("ua", "iphone");
        account_commonUp.put("os", "ios");
        account_commonUp.put("vs", "2.0.0");
        account_commonUp.put("vc", "35");
        account_commonUp.put("sw", "480");
        account_commonUp.put("sh", "800");
        account_commonUp.put("serial", "803330");
        account_commonUp.put("udid", "uqwbejqweqwoeqnwekjasdad");
        account_commonUp.put("channel", "11");
        account_commonUp.put("contype", 1);
        account_commonUp.put("imei", "");
        account_commonUp.put("imsi", "");
        account_commonUp.put("mac", "qwe123123ada231");
        logger.info("[method]: setCommonUp end ----------");
    }

    //设置账户
    public void setAccount(String type) {
        logger.info("[method]: setAccount start ----------");
        try {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            if("test".equals( type )){
                account_uname = getPropertiesData.getData("phone");
                account_pwd = getPropertiesData.getData("password-mall");
            }else if("exceptionTest".equals( type )){
                account_uname = getPropertiesData.getData("loginUserException");
                account_pwd = getPropertiesData.getData("passwordException");
            }

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
                json.put("token", Mallh5_parent.account_token);
            } else if (tokenValue.equals("expired")) {
                String expieredToken = buildExpiredToken( Mallh5_parent.account_token);
                json.put("token", expieredToken);
            } else {
                json.put("token", tokenValue);
            }
        }
    }


    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_mall_normal";
        RunningParameter.monitor_projectId = 21;
        RunningParameter.projectName = "mall";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_mall_exception";
        RunningParameter.monitor_projectId = 21;
        RunningParameter.projectName = "mall";
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
    public void startup() {
        RunningParameter.projectName = "mall";
        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeaderMallH5();
        //设置公共上行
        setCommonUp();
        //设置用户名密码
        setAccount("test");
        //更新token
        Mallh5_login login = new Mallh5_login();
        login.login();
    }
    @BeforeTest(groups = {"exception"})
    public void startupexception() {
        RunningParameter.projectName = "mall";
        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeaderMallH5();
        //设置公共上行
        setCommonUp();
        //设置用户名密码
        setAccount("exceptionTest");
        //更新token
        Mallh5_login login = new Mallh5_login();
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
        getCaseBasicInfoMallH5(param);
        //getCaseBasicInfo(param);
        getUpData(param);
        JSONObject jsonObject = JSONObject.parseObject(requestSampler.getRequestInfo());
        requestSampler.setRequestInfo(JSONObject.toJSONString(jsonObject));
        requestSampler.setRequestProId("10", "");
        //发送请求
        //new APIHttpClient().executePostRequest(requestSampler);
        new Mallh5_login().executePostRequestH5( requestSampler );
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
        requestSampler.setGetRequsetParams(getRequestParms);
    }


    //shenbingbing add start 手机商城H5专用
    public String getInterfaceUrlLogin() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        return getPropertiesData.getData( "UrlHeader_login" ) + RunningParameter.apiXml.getElementText( "//" + this.getClass().getSimpleName() );
    }

    public String getInterfaceUrlMallH5() {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            return getPropertiesData.getData( "UrlHeader-mallh5" ) + RunningParameter.apiXml.getElementText( "//" + this.getClass().getSimpleName() );
    }
    public void getCaseBasicInfoMallH5(Map<String, String> param) {
        requestSampler.setRequestUrl(getInterfaceUrlMallH5());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setKeyWord(param.get("keyWord"));
        if (this.requestSampler.getType() != 2)
            logger.info(requestSampler.getInterfaceName() + " - " + requestSampler.getTestCaseName());
    }

    public void getUrlHeaderMallH5() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        getPropertiesData.getData("UrlHeader_login");
        //RunningParameter.UrlHeader_login = getPropertiesData.getData("UrlHeader_login");
        this.logger.info("[UrlHeader_login]: " + getPropertiesData.getData("UrlHeader_login"));
    }
    //shenbingbing add end 手机商城H5专用
    public void getRequest(Map<String, String> param) {
        getCaseBasicInfoMallH5(param);
        getParams(param);

        APIHttpClient apiHttpClient = new APIHttpClient();
        requestSampler.setRequestProId("10", "");
        //send request
        //apiHttpClient.getRequest(requestSampler);
        new Mallh5_login().getRequestH5( requestSampler );
        //getRequests(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        isSuccess(requestSampler);
    }
}
