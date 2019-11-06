package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 提交批改数据
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_4 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("publish_id", param.get("publish_id"));
        jsonObject.put("link_id", param.get("link_id"));
        jsonObject.put("question_id", param.get("question_id"));
        jsonObject.put("scene_type", param.get("scene_type"));
        jsonObject.put("struct_id", param.get("struct_id"));
        jsonObject.put("student_id", param.get("student_id"));
        jsonObject.put("sub_question_id", param.get("sub_question_id"));

        ArrayList<Map<String, String>> answer = new ArrayList<>();
        Map<String, String> m = new HashMap<>();
        m.put("index", param.get("index"));
        m.put("status", param.get("status"));
        answer.add(m);
        jsonObject.put("answer", answer);


        return jsonObject.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequest(param);
    }
}
