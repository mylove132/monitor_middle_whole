package okjiaoyu.qa.middle.auto.testcase.teacherpad.prepare;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加收藏
 * <p>
 * Created by zhudong on 2018/8/24.
 */
public class Api1_1 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("type", Integer.parseInt(param.get("type")));
        jsonObject.put("rid", param.get("rid"));
        jsonObject.put("custom_directory_id", param.get("custom_directory_id"));
        jsonObject.put("custom_system_id", param.get("custom_system_id"));
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
