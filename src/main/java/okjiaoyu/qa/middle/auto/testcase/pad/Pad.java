package okjiaoyu.qa.middle.auto.testcase.pad;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.pad.rom.Api_login;
import okjiaoyu.qa.tools.*;
import org.testng.annotations.*;

import java.util.Date;
import java.util.Map;

/**
 * Created by 晓 on 2015/7/11.
 */
public class Pad extends TestBase {

    static {
        RunningParameter.projectName = "studentpad";
//        String machine = Config.getGlobalValue("machine");
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        String machine = getPropertiesData.getData("machine");
        if (machine.equals("windows")) {
            Pad.pics = new String[]{"E:\\data\\monitor\\pad\\20160109-01.png", "E:\\data\\monitor\\pad\\20160109-02.png"};
        } else if (machine.equals("linux")) {
            Pad.pics = new String[]{"/home/work/files/pad/20160109-01.png", "/home/work/files/pad/20160109-02.png"};
        }
    }

    public static String account_uname = "";
    public static String account_pwd = "";
    public static String account_uid = "";
    public static String account_token = "";
    public static JSONObject account_commonUp = new JSONObject();
    public static String[] pics;

    public void setCommonUp() {
        logger.info("[method]: setCommonUp start ----------");
        account_commonUp.put("vs", "1.2.0");
        account_commonUp.put("vc", "35");
        account_commonUp.put("ua", "aliyunos");
        account_commonUp.put("os", "android");
        account_commonUp.put("sw", "480");
        account_commonUp.put("sh", "800");
        account_commonUp.put("contype", 1);
        account_commonUp.put("imei", "qwiuenqweqadas");
        account_commonUp.put("mac", "qwe123123ada23111");
        account_commonUp.put("channel", "168");
        account_commonUp.put("udid", "uqwbejqweqwoeqnwekjasdadd");
        logger.info("[method]: setCommonUp end ----------");
    }

    //设置账户
    public void setAccount() {
        logger.info("[method]: setAccount start ----------");
        try {
            RSA rsa = new RSA();
            String pwd = "";
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            account_uname = getPropertiesData.getData("account");
            pwd = getPropertiesData.getData("pwd");
//            if(RunningParameter.env.equals("test")){
//                account_uname = Config.getModuleConfig("test-account");
//                pwd = Config.getModuleConfig("test-pwd");
//            }else if(RunningParameter.env.equals("online")){
//                account_uname = Config.getModuleConfig("online-account");
//                pwd = Config.getModuleConfig("online-pwd");
//
//            }else if(RunningParameter.env.equals("hotfix")){
//                account_uname = Config.getModuleConfig("hotfix-account");
//                pwd = Config.getModuleConfig("hotfix-pwd");
//
//            }
            logger.info("[account_uname]:" + account_uname);
            logger.info("[pwd]:" + pwd);
            logger.info("redisIp" + RunningParameter.redisIp);
            logger.info("redisPort" + RunningParameter.redisPort);

            //根据存储在redis里的最新的PUB_KEY，获得加密后的密码
            account_pwd = rsa.getPassword(pwd);
//            account_pwd = rsa.getPasswordFromRedis(pwd, 1);
            logger.info("[account_pwd]:" + account_pwd);
            RunningParameter.uname = account_uname;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            logger.error("occur a problem during setAccount!");
        }

        logger.info("[method]: setAccount end ----------");
    }

    public void getUnameValue(String unameValue, JSONObject json) {
        if (!unameValue.equals("miss")) {
            if (unameValue.equals("newest")) {
                json.put("uname", Pad.account_uname);
            } else {
                json.put("uname", unameValue);
            }
        }
    }

    public void getUidValue(String uidValue, JSONObject json) {
        if (!uidValue.equals("miss")) {
            if (uidValue.equals("newest")) {
                json.put("uid", Pad.account_uid);
            } else {
                json.put("uid", uidValue);
            }
        }
    }

    public void getPwdValue(String pwdValue, JSONObject json) {
        if (!pwdValue.equals("miss")) {
            if (pwdValue.equals("newest")) {
                json.put("pwd", Pad.account_pwd);
            } else {
                json.put("pwd", pwdValue);
            }
        }
    }

    public void getPwdValue(String pwdValue, JSONObject json, String key) {
        if (!pwdValue.equals("miss")) {
            if (pwdValue.equals("newest")) {
                json.put(key, Pad.account_pwd);
            } else {
                RSA rsa = new RSA();
                json.put(key, rsa.getPassword(pwdValue));
            }
        }
    }

    public void getTokenValue(String tokenValue, JSONObject json) {
        if (!tokenValue.equals("miss")) {
            if (tokenValue.equals("newest")) {
                json.put("token", Pad.account_token);
            } else if (tokenValue.equals("expired")) {
                String expieredToken = buildExpiredToken(Pad.account_token);
                json.put("token", expieredToken);
            } else {
                json.put("token", tokenValue);
            }
        }
    }


    public void getRedisInfo() {
        if (RunningParameter.redisIp.equals("")) {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            RunningParameter.redisIp = getPropertiesData.getData("redisIp");
//            switch (RunningParameter.env){
//                case "hotfix":
//                    RunningParameter.redisIp = Config.getGlobalValue("redisIp_hotfix");
//                    break;
//                case "dev":
//                    RunningParameter.redisIp = Config.getGlobalValue("redisIp_test");
//                    break;
//                case "online":
//                    RunningParameter.redisIp = Config.getGlobalValue("redisIp_online");
//                    break;
//                default:
//                    logger.error("Error with the env:" + RunningParameter.env);
//            }
        }
        if (RunningParameter.redisPort == 0) {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            RunningParameter.redisPort = Integer.parseInt(getPropertiesData.getData("redisPort"));
//            switch (RunningParameter.env){
//                case "hotfix":
//                    RunningParameter.redisPort = Integer.parseInt(Config.getGlobalValue("redisPort_hotfix"));
//                    break;
//                case "dev":
//                    RunningParameter.redisPort = Integer.parseInt(Config.getGlobalValue("redisPort_test"));
//                    break;
//                case "online":
//                    RunningParameter.redisPort = Integer.parseInt(Config.getGlobalValue("redisPort_online"));
//                    break;
//                default:
//                    logger.error("Error with the env:" + RunningParameter.env);
//            }
        }
    }

    @BeforeSuite(groups = {"normal"})
    public void beforeSuite_normal() {
        RunningParameter.project_name = "middle_studentpad_normal";
        RunningParameter.monitor_projectId = 1;
    }

    @BeforeSuite(groups = {"exception"})
    public void beforeSuite_exception() {
        RunningParameter.project_name = "middle_studentpad_exception";
        RunningParameter.monitor_projectId = 1;
    }


    @BeforeTest(groups = {"normal", "exception"})
    public void startup() {

        //module settings
        RunningParameter.projectName = "studentpad";
        RunningParameter.settingFilePath = "/url/pad/setting.xml";

        //获取环境信息
        getEnv();
        //get Redis info
        getRedisInfo();
        //获取接口配置文件
        getApiXml();
        //获取请求UrlHeader
        getUrlHeader();
        //设置公共上行
        setCommonUp();
        //设置用户名密码
        setAccount();

        //更新uid和token
        Api_login al = new Api_login();
        al.updateLogin();
    }

    //发送post请求
    public void postRequest(Map<String, String> param) {
        getCaseBasicInfo(param);
        getUpData(param);
        //发送请求
        requestSampler.setRequestProId("02", "");
        requestSampler.post();
        logger.info("[RequestInfo]:" + requestSampler.getrequestDetailInfo());
        logger.info("[ResponseJson]:" + requestSampler.getResponseInfo());
        //断言，打印结果
        isSuccess(requestSampler);
    }

    public void uploadPic() {
        //requestInfo
        requestSampler.setType(0);//正常用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName(getInterfaceName() + " - 成功上传图片");
        requestSampler.setExpectedCode("0");
        //form-data
        requestSampler.setRequestProId("02", "");
        requestSampler.getFormValuePairs().put("uid", Pad.account_uid);
        requestSampler.getFormValuePairs().put("token", Pad.account_token);
        requestSampler.getFormValuePairs().put("description", "[{\"id\":\"1408084\",\"imgArray\":[\"20160109-01_0\",\"20160109-01_1\"]}]");
        requestSampler.getFormFiles().put("20160109-01_0", Pad.pics[0]);
        requestSampler.getFormFiles().put("20160109-01_1", Pad.pics[1]);
        //发送请求
        APIHttpClient httpClient = new APIHttpClient();
        logger.info("[requestUrl]:" + requestSampler.getRequestUrl());
        httpClient.postFormdata(requestSampler);
        //断言，打印结果
        isSuccess(requestSampler);
    }

    public void uploadPic_DataTest(RequestSampler rs) {
        JSONObject responseJson = JSONObject.parseObject(rs.getResponseInfo());
        //题集id
        String emsg = responseJson.getJSONObject("meta").get("emsg").toString();
        String ecode = responseJson.getJSONObject("meta").get("ecode").toString();
        JSONObject array = responseJson.getJSONObject("data").getJSONObject("imgarray");
        if (emsg.equals("成功") && ecode.equals("0")) {
            rs.setDataCheck(true);
            rs.setDataCheckDetail("成功上传" + array.size() + "张图片：" + JSONObject.toJSONString(array));
        } else {
            rs.setDataCheck(false);
            rs.setDataCheckDetail("上传图片失败");
        }
    }

}
