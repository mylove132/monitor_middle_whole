//package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
//
//// Created by peidongdong on 2018/1/24.
//// for interface 2.1 apiRequest
//// 1.24 [自主学习][推荐错题，推荐习题]–提交答题接口
//
//
//public class Api1_24 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
//        json.put("workid", param.get("workid"));
//        json.put("kid", param.get("kid"));
//        json.put("ktype", Integer.parseInt(param.get("ktype")));
//        json.put("answertype", Integer.parseInt(param.get("answertype")));
//        json.put("intros", param.get("intros"));
//
//        json.put("exersice_key", param.get("exersice_key"));
//
//        JSONObject myJson = new JSONObject();
//        String[] qids = {param.get("qids")};
//        myJson.put("qids", qids);
//        myJson.put("qtype", Integer.parseInt(param.get("qtype")));
//        myJson.put("submitanswer", param.get("submitanswer"));
//        myJson.put("result", param.get("result"));
//        myJson.put("structid", param.get("structid"));
//        myJson.put("submittype", Integer.parseInt(param.get("submittype")));
//        myJson.put("sid", Integer.parseInt(param.get("sid")));
//
//        JSONArray qanswers = new JSONArray();
//        qanswers.add(myJson);
//        json.put("qanswers", qanswers);
//        return json.toJSONString();
//
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
