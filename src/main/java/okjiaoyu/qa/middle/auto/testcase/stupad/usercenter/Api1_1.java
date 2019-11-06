package okjiaoyu.qa.middle.auto.testcase.stupad.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/7.
 * for interface 2.1 apiRequest
 * 1.1 登录
 */
//public class Api1_1 extends Pad {

//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        getUnameValue(param.get("uname"), json);
//        getPwdValue(param.get("pwd"), json);
//        return json.toJSONString();
//    }
//
////    public void updateLogin(){
////        //uame and pwd
////        JSONObject json = new JSONObject();
////        json.put("uname", account_uname);
////        json.put("pwd", account_pwd);
////        json.putAll(account_commonUp);
////        //request
////        RequestSampler rs = new RequestSampler(json.toString());
////        rs.setTestCaseName("更新uid和token");
////        rs.setType(2);
////        rs.setRequestUrl(getInterfaceUrl());
////        rs.post();
////        logger.debug(rs.getrequestDetailInfo());
////        JSONObject json_response =JSONObject.parseObject(rs.getResponseInfo());
////        //update uid and token
////        account_uid = JSONObject.parseObject(json_response.get("data").toString()).get("uid").toString();
////        account_token = JSONObject.parseObject(json_response.get("data").toString()).get("token").toString();
////
////        logger.debug("重新进行登录操作，更新后的uid和token：" + account_uid + " " + account_token);
////    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postRequest(param);
//    }

//}