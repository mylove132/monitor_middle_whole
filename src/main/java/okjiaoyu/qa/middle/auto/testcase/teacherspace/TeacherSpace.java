package okjiaoyu.qa.middle.auto.testcase.teacherspace;

import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter.Th_login;
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
 * Created by zhang on 2016/1/13.
 */

public class TeacherSpace extends TestBase {

    public TeacherSpace() {
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
        RunningParameter.uname = loginUser;
        logger.info("[method]: setAccount end ----------");
    }

    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_teacher_normal";
        RunningParameter.monitor_projectId = 2;
        RunningParameter.projectName = "teacherspace";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_teacher_exception";
        RunningParameter.monitor_projectId = 2;
        RunningParameter.projectName = "teacherspace";
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
        RunningParameter.projectName = "teacherspace";
//        RunningParameter.settingFilePath = "/config/spring/applicationConfig.xml";
//        RunningParameter.settingFilePathforTeacher = "/config/spring/applicationConfig.xml";
        RunningParameter.settingFilePath = "/url/teacherspace/setting.xml";
        RunningParameter.settingFilePathforTeacher = "/url/teacherspace/setting.xml";

        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置用户名密码
        setAccount();
        //更新cookies
        Th_login th_login = new Th_login();
        th_login.login();
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
        requestSampler.setRequestProId("01", "");
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

        //request params
        getParams(param);
        requestSampler.setRequestProId("01", "");
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
        logger.info("[ResponseJson]: " + requestSampler.getResponseInfo());

        //isSuccess
        isSuccess(requestSampler);
        logger.info(" [CaseAmount]: " + RunningParameter.caseAmount);
        logger.info(" [passCaseAmount]: " + RunningParameter.passAmount);
        logger.info(" [failCaseAmount]: " + RunningParameter.failAmount);

    }

}
