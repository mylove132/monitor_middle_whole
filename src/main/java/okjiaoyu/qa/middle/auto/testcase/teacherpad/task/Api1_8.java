package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 获取作答情况
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_8 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("link_id", param.get("link_id"));
        jsonObject.put("publish_id", param.get("publish_id"));
        jsonObject.put("q_flag", param.get("q_flag"));
        jsonObject.put("question_id", param.get("question_id"));
        jsonObject.put("resource_id", param.get("resource_id"));
        jsonObject.put("scene_type", param.get("scene_type"));
        jsonObject.put("student_id", param.get("student_id"));
        return jsonObject.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestTest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestTest(param);
    }
}
