//package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingresource;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 自建体系_创建及编辑
// */
//
//public class Api1_2 extends PublicWeb {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id", Integer.parseInt(param.get("id")));
//        jsonObject.put("name", param.get("name"));
//        jsonObject.put("stage_id", Integer.parseInt(param.get("stage_id")));
//        jsonObject.put("status", Integer.parseInt(param.get("status")));
//        jsonObject.put("subject_id", Integer.parseInt(param.get("subject_id")));
//        return jsonObject.toJSONString();
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        postRequest(param);
//    }
//
//
//}
