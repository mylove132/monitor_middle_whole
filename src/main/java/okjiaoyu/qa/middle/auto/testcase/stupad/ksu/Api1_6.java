//package okjiaoyu.qa.middle.auto.testcase.stupad.ksu;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by peidongdong on 2018/5/29.
// * 1.6 求助页面获取推荐老师列表
// */
//public class Api1_6 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
//        json.put("kid", Integer.parseInt(param.get("kid")));
//        json.put("ktype", Integer.parseInt(param.get("ktype")));
//        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
//        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
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
