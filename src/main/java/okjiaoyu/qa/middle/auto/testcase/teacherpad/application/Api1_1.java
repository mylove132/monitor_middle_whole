//package okjiaoyu.qa.middle.auto.testcase.teacherpad.application;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 查询APP升级
// * <p>
// * Created by chaozhe on 2017/6/12.
// */
//public class Api1_1 extends TeacherPad {
//
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("orgtype", Integer.parseInt(param.get("orgtype")));
//        jsonObject.put("sid", param.get("sid"));
//        jsonObject.put("channel", param.get("channel"));
//
//        ArrayList<Map<String, Object>> apps = new ArrayList<>();
//        Map<String, Object> m = new HashMap<>();
//        m.put("app", param.get("app"));
//        m.put("vcode", Integer.parseInt(param.get("vcode")));
//        apps.add(m);
//        jsonObject.put("apps", apps);
//
//        ArrayList<String> sidlist = new ArrayList<>();
//        sidlist.add(param.get("sidlist"));
//        jsonObject.put("sidlist", sidlist);
//
//
//        return jsonObject.toJSONString();
//    }
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
//}
