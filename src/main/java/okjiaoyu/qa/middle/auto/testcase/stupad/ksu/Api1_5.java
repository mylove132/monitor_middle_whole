//package okjiaoyu.qa.middle.auto.testcase.stupad.ksu;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by peidongdong on 2018/5/29.
// * 1.5 求助我的老师和已购买的机构列表
// */
//public class Api1_5 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
//        json.put("kid", param.get("kid"));
//        json.put("ktype", Integer.parseInt(param.get("ktype")));
//        json.put("klevel", Integer.parseInt(param.get("klevel")));
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
