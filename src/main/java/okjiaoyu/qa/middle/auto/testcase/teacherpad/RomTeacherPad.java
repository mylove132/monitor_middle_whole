package okjiaoyu.qa.middle.auto.testcase.teacherpad;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.RomTestBase;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter.Teacherpad_Login;
import okjiaoyu.qa.tools.GetPropertiesData;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.TestReport;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.Date;
import java.util.Map;

/**
 * Created by ${chaozhe} on 2017/6/5.
 */
public class RomTeacherPad extends RomTestBase {
    public static String account_token = "";
    public static String account_uid = "";

    public RomTeacherPad() {
        this.requestSampler = new RequestSampler();
    }

    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_teacherpad_normal";
        RunningParameter.monitor_projectId = 28;
        RunningParameter.projectName = "teacherpad";
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_teacherpad_exception";
        RunningParameter.monitor_projectId = 28;
        RunningParameter.projectName = "teacherpad";
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
        //获取测试环境
        RunningParameter.projectName = "teacherpad";
        getEnv();
        //获取接口配置文件
        getApiXml();
        //获取请求地址-公共部分
        getUrlHeader();
        //设置用户名密码
        setAccount();

//        Teacherpad_Login app = new Teacherpad_Login();
//        app.login();


    }

    public static String loginUser;
    public static String password;

    private void setAccount() {
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        loginUser = getPropertiesData.getData("loginUser");
        password = getPropertiesData.getData("password");
    }

    /**
     * 1、入参不需要token
     * 2、使用登陆返回的token
     * 3、使用用例xml中的token
     *
     * @param token
     * @param json
     */
    public void getLoginToken(String token, JSONObject json) {
        if (!token.equals("miss")) {
            if (token.equals("used")) {
                json.put("token", account_token);
            } else if (token.equals("expired")) {
                json.put("token", buildExpiredToken(RomTeacherPad.account_token + "_expired"));
            } else {
                json.put("token", token);
            }
        }
    }

    public void getLoginUid(String uid, JSONObject json) {
        if (!uid.equals("miss")) {
            if (uid.equals("used")) {
                json.put("uid", account_uid);
            } else if (uid.equals("expired")) {
                json.put("uid", buildExpiredToken(RomTeacherPad.account_uid));
            } else {
                json.put("uid", uid);
            }
        }

    }

    /**
     * 发送post请求
     *
     * @param param
     */
    public void postRequest(Map<String, String> param) {
        getCaseBasicInfo(param);
        //调用基类，将上边用例中参数放入request中
        getUpData(param);
        //设置请求项目id
        requestSampler.setRequestProId("03", "");
        requestSampler.post();
        logger.info("[RequestInfo]:" + requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]:" + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    /**
     * 发送post请求(过滤器)
     *
     * @param param
     */
    public void postRequestTest(Map<String, String> param) {
        getCaseBasicInfo(param);
        //调用基类，将上边用例中参数放入request中
        getUpData(param);
        //设置请求项目id
        requestSampler.setRequestProId("03", "");
        requestSampler.postTest();
        logger.info("[RequestInfo]:" + requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]:" + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

}