//package okjiaoyu.qa.middle.auto.testcase.stupad.common;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by peidongdong on 2017/11/16.
// * 1.4 纠错问询
// */
//public class Api1_4 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getUidValue(param.get("uid"), json);
//        getTokenValue(param.get("token"), json);
//
//        Long[] qid = new Long[]{Long.parseLong(param.get("qid"))};
//        json.put("qid", qid);
//        return json.toJSONString();
//    }
//
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//        postRequest(param);
//    }
//
//}
