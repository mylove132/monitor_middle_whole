package okjiaoyu.qa.middle.auto.testcase.teacherpad.course;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 开放资源给学生
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_5 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", account_token);
        jsonObject.put("uid", account_uid);
        jsonObject.put("publish_id", param.get("publish_id"));
        jsonObject.put("resource_id", param.get("resource_id"));
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
