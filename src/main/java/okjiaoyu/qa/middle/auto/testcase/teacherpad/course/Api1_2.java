package okjiaoyu.qa.middle.auto.testcase.teacherpad.course;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import okjiaoyu.qa.tools.APIHttpClient;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 查询发布课程--先执行，可以获取上课id
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_2 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("class_id", param.get("class_id"));
        jsonObject.put("directory_id", param.get("directory_id"));
        jsonObject.put("page", param.get("page"));
        jsonObject.put("type_publish", param.get("type_publish"));
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
