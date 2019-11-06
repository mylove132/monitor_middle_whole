package okjiaoyu.qa.middle.auto.testcase.parentApp.parent;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.tools.APIHttpClient;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 每次调用之前先登录
 * Created by shenbingbing on 2019/02/18.
 */
public class Pa_login_parent extends ParentApp_parent {

//    @Override
//    public void responseTest(RequestSampler requestSampler) {
//        JSONObject json = JSONObject.parseObject(requestSampler.getResponseInfo());
//        String emsg = json.get("message").toString();
//        String expectedEmsg = "登录成功";
//
//        requestSampler.setDataCheck(true);
//        requestSampler.setPass(emsg.equals(expectedEmsg));
//        Assert.assertEquals(emsg,expectedEmsg);
//    }

    @Test
    public void login() {
        Map<String, String> parameters = new HashMap<>();
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
        parameters.put("role", "0");
        //shen start
        Map<String, String> map = new HashMap<>();
        map.put("account", account_uname);
        map.put("pwd", account_pwd);
        map.put( "type","1" );
        //shen end
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "type",map);
        jsonObject.putAll(parameters);
        requestSampler.setRequestInfo(jsonObject.toJSONString());
        logger.info("[requestJson]:" + JSONObject.toJSONString(jsonObject));
        //requestSampler.setRequestInfo(JSONObject.toJSONString(jsonObject));
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setTestCaseName("登陆");
        //发送请求
        new APIHttpClient().executePostRequest(requestSampler);
        JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
        //System.out.println("结果是: " + responseJson);
        logger.info( "okay+登录接口返回结果: " + responseJson );
        //account_token = responseJson.getJSONObject("data").get("token").toString();
        account_token=responseJson.getJSONObject( "data" ).getJSONObject( "parent" ).get( "token" ).toString();
        logger.info("okay+登录返回account-token is: " + account_token);
        account_uid = responseJson.getJSONObject("data").getJSONObject( "parent" ).get("uid").toString();
        logger.info("okay+登录返回account-uid is: " + account_uid);
    }
}
