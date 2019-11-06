package okjiaoyu.qa.middle.auto.testcase.teacherpad.prepare;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 推荐资源
 * <p>
 * Created by zhudong on 2018/8/24.
 */

public class Api1_3 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("orig_type", Integer.parseInt(param.get("orig_type")));
        jsonObject.put("res_type", Integer.parseInt(param.get("res_type")));
        jsonObject.put("start_num", param.get("start_num"));
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
