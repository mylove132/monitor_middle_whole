package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 查看总体详情
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_5 extends TeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("link_id", param.get("link_id"));
        jsonObject.put("r_id", param.get("r_id"));
        jsonObject.put("scene_type", param.get("scene_type"));
        jsonObject.put("show_type", Integer.parseInt(param.get("show_type")));
        jsonObject.put("seq", Integer.parseInt(param.get("seq")));
        jsonObject.put("sort", Integer.parseInt(param.get("sort")));
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
