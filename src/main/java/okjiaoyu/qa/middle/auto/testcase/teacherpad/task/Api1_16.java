package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 批改搜索接口
 * <p>
 * Created by zhudong on 2017/6/12.
 */
public class Api1_16 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("package_desc", Integer.parseInt(param.get("package_desc")));
        jsonObject.put("scene_type", Integer.parseInt(param.get("scene_type")));
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
