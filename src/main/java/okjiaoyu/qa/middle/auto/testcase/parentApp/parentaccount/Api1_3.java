package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;//package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;
//
//import com.alibaba.fastjson.JSONObject;
//
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
////注销登录
//
//public class Api1_3 extends ParentApp {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        json.put("token", account_token);
//        json.put("uid", account_uid);
//        return json.toJSONString();
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequestByJson(param);
//    }
//
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postRequestByJson(param);
//    }
//
//}