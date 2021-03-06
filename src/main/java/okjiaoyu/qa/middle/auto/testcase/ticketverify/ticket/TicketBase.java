package okjiaoyu.qa.middle.auto.testcase.ticketverify.ticket;

import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter.Th_login;
import okjiaoyu.qa.tools.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2016/1/13.
 */

public class TicketBase extends TestBase {

    public TicketBase() {
        this.requestSampler = new RequestSampler();
    }

    public static String loginUser = "";
    public static String password = "";
    public static String validateCode = "";
    public static String password_new = "";

    //设置账户
    public void setAccount() {
        logger.info("[method]: setAccount start ----------");
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        loginUser = getPropertiesData.getData("loginUser");
        password = getPropertiesData.getData("password");
        validateCode = getPropertiesData.getData("validateCode");
        password_new = getPropertiesData.getData("password_new");

//        String env = Config.getGlobalValue("env");
//        if(env.equals("test")){
//            loginUser = Config.getModuleConfig("test-loginUser");
//            password = Config.getModuleConfig("test-password");
//            validateCode = Config.getModuleConfig("test-validateCode");
//            password_new = Config.getModuleConfig("test-password_new");
//        }else if(env.equals("online")){
//            loginUser = Config.getModuleConfig("online-loginUser");
//            password = Config.getModuleConfig("online-password");
//            validateCode = Config.getModuleConfig("online-validateCode");
//            password_new = Config.getModuleConfig("online-password_new");
//        }
        RunningParameter.uname = loginUser;
        logger.info("[method]: setAccount end ----------");
    }


    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "ticketverify_normal";
        RunningParameter.monitor_projectId = 2;
        RunningParameter.projectName = "ticketverify";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "ticketverify_exception";
        RunningParameter.monitor_projectId = 2;
        RunningParameter.projectName = "ticketverify";
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

    @BeforeTest(groups = {"normal", "exception"})
    public void startup() {
        //module settings
        RunningParameter.projectName = "ticketverify";
        RunningParameter.settingFilePath = "/url/ticketverify/setting.xml";
        RunningParameter.settingFilePathforTeacher = "/url/ticketverify/setting.xml";

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount();
    }

    //params for get request
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
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
        requestSampler.setRequestProId("01", "");
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        requestSampler.setType(Integer.parseInt(param.get("caseType")));
        APIHttpClient apiHttpClient = new APIHttpClient();
        // apiHttpClient.setCookies();
        //send request
        apiHttpClient.getRequest(requestSampler);
        logger.info(requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());
        //isSuccess
        logger.info(" [CaseAmount]: " + RunningParameter.caseAmount);
        logger.info(" [passCaseAmount]: " + RunningParameter.passAmount);
        logger.info(" [failCaseAmount]: " + RunningParameter.failAmount);
        isSuccess(requestSampler);
    }

}
