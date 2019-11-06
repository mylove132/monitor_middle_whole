//package okjiaoyu.qa.middle.auto.testcase.stupad.hardware;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by zhudong on 2018/10/12.
// *
// * 4.3知识点报告页加入魔镜，加入主屏 从主屏移除，我学会了
// */
//public class Api1_6 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
//        json.put("ktype", param.get("ktype"));
//        json.put("kid", param.get("kid"));
//        json.put("klevel", param.get("klevel"));
//        json.put("operation", param.get("operation"));
//        return json.toJSONString();
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        postRequest(param);
//    }
//
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//        postRequest(param);
//    }
//
//
//}
