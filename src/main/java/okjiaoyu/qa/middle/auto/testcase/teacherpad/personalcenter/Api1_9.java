package okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by chaozhe on 2017/10/24.
 * 移除账号 只有异常用例，移除不存在的学生
 */
public class Api1_9 extends TeacherPad {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("class_id", param.get("class_id"));
        jsonObject.put("password", param.get("password"));
        jsonObject.put("student_id", param.get("student_id"));
        return jsonObject.toJSONString();
    }
   /* @Test(dataProvider = "providerMethod", groups = { "normal" })
    public void test(Map<String, String> param){
        postRequest(param);
    }*/

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequest(param);
    }
}
