package okjiaoyu.qa.middle.auto.testcase.mall;

import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.mall.shop.H5_login;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.GetPropertiesData;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.TestReport;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2017/6/28.
 */

public class Mall extends TestBase {

    public Mall() {
        this.requestSampler = new RequestSampler();
    }

    public static String phone = "";
    public static String password = "";

    static {
        RunningParameter.projectName = "mall";
    }

    //设置账户
    public void setAccount(String type) {
        logger.info("[method]: setAccount start ----------");
        GetPropertiesData getPropertiesData = new GetPropertiesData();
      /*  phone = getPropertiesData.getData("phone");
        password = getPropertiesData.getData("password");*/
        if("test".equals( type )){
            phone = getPropertiesData.getData("phone");
            password = getPropertiesData.getData("password");
        }else if("exceptionTest".equals( type )){
            phone = getPropertiesData.getData("loginUserException");
            password = getPropertiesData.getData("password");
        }
        RunningParameter.uname = phone;
        logger.info("[method]: setAccount end ----------");
    }

    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_mall_normal";
        RunningParameter.monitor_projectId = 29;
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_mall_exception";
        RunningParameter.monitor_projectId = 29;
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
        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount("test");
        //更新cookies
        H5_login h5_login = new H5_login();
        h5_login.login();
    }
    @BeforeTest(groups = {"exception"})
    public void startupexception() {
        //module settings
        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount("exceptionTest");
        //更新cookies
        H5_login h5_login = new H5_login();
        h5_login.login();
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
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    //发送Form请求
    public void postFormRequest(Map<String, String> param) {
        getCaseBasicInfo(param);
        getParams(param);
        //发送请求
        APIHttpClient apiHttpClient = new APIHttpClient();
        apiHttpClient.setCookies();
        //send request
        requestSampler.setRequestProId("10", "");
        apiHttpClient.postFormdata(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    //params for get request
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        NameValuePair collection_id = new BasicNameValuePair("collection_id", param.get("collection_id"));
        NameValuePair type = new BasicNameValuePair("type", param.get("type"));
        getRequestParms.add(collection_id);
        getRequestParms.add(type);
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    //send Get request
    public void getRequest(Map<String, String> param) {
        logger.info(" [CaseAmount]: " + RunningParameter.caseAmount);
        logger.info(" [passCaseAmount]: " + RunningParameter.passAmount);
        logger.info(" [failCaseAmount]: " + RunningParameter.failAmount);
        //request params
        getParams(param);
        System.out.println("param:" + param);
        requestSampler.setRequestProId("10", "");
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
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson11]: " + requestSampler.getResponseInfo());
        //isSuccess
        logger.info(" [CaseAmount]: " + RunningParameter.caseAmount);
        logger.info(" [passCaseAmount]: " + RunningParameter.passAmount);
        logger.info(" [failCaseAmount]: " + RunningParameter.failAmount);
        isSuccess(requestSampler);
    }

}
