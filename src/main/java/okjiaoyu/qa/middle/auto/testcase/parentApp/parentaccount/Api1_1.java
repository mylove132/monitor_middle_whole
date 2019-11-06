package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;//package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;
//
//import com.alibaba.fastjson.JSONObject;
//
//import org.testng.annotations.Test;
//
//import java.util.Map;
////登陆
//
//public class Api1_4 extends ParentApp {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        json.put("account", param.get("account"));
//        json.put("pwd", param.get("pwd"));
//
//        return json.toJSONString();
//    }
//
////    @Test(dataProvider = "providerMethod", groups = { "normal" })
////    public void test(Map<String, String> param){
////        postRequestByJson(param);
////    }
//
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequestByJson(param);
//    }
//
//}