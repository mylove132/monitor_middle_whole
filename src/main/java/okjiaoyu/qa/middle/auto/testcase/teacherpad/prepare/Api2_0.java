package okjiaoyu.qa.middle.auto.testcase.teacherpad.prepare;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 章节目录筛选习题请求列表
 * <p>
 * Created by zhudong on 2019/6/4.
 */

public class Api2_0 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("custom_directory_id", param.get("custom_directory_id"));
        jsonObject.put("custom_directory_level", Integer.parseInt(param.get("custom_directory_level")));
        jsonObject.put("origin", param.get("origin"));
        jsonObject.put("page", Integer.parseInt(param.get("page")));
        jsonObject.put("page_size", Integer.parseInt(param.get("page_size")));
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
