package okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 获取加密信息
 * Created by chaozhe on 2017/6/13.
 */
public class Api1_3 extends TeacherPad {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }
}
