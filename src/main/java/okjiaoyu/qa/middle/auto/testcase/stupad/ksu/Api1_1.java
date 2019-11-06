//package okjiaoyu.qa.middle.auto.testcase.stupad.ksu;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by 朱栋 on 2019/07/05
// * 1.1 [小云] 获取推荐知识点
// */
//public class Api1_1 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
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
