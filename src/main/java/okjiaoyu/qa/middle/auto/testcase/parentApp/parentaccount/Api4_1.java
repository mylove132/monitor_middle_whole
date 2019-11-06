package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;//package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.domain.RequestSampler;
//
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
////App检查更新
//
//public class Api4_1 extends ParentApp {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        json.put("vc", param.get("vc"));
//        json.put("apppkg", param.get("apppkg"));
//        return json.toJSONString();
//    }
//
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