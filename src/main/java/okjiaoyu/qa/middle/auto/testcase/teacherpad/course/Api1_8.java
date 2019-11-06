package okjiaoyu.qa.middle.auto.testcase.teacherpad.course;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 获取习题的学生作答详情
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
        jsonObject.put("quiz_id", param.get("quiz_id"));
        jsonObject.put("statistic_type", param.get("statistic_type"));
        jsonObject.put("type", param.get("type"));
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
