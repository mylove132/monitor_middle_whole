//package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * 检查是否支持智能批改
// * <p>
// * Created by chaozhe on 2017/6/12.
// */
//public class Api1_7 extends TeacherPad {
//
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param) {
//        JSONObject jsonObject = new JSONObject();
//        getLoginUid(param.get("uid"), jsonObject);
//        getLoginToken(param.get("token"), jsonObject);
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
