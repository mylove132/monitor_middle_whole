package okjiaoyu.qa.middle.auto.testcase.teacherpad.prepare;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 获取最后一次点击目录
 * <p>
 * Created by zhudong on 2018/8/24.
 */

public class Api1_6 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
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
