package okjiaoyu.qa.middle.auto.testcase.teacherpad.launcher;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong  on   2018/9/27.
 * for interface1.1 apiRequest
 * 深度学习入口
 */
public class Api1_1 extends TeacherPad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getLoginUid(param.get("uid"), json);
        getLoginToken(param.get("token"), json);
        json.put("iccid", param.get("iccid"));

        return json.toJSONString();
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


