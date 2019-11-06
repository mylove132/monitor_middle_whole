package okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by chaozhe on 2017/10/24.
 * 获取教师辅导权限（直播需求添加）
 */
public class Api2_0 extends TeacherPad {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        return jsonObject.toJSONString();
    }
   /* @Test(dataProvider = "providerMethod", groups = { "normal" })
    public void test(Map<String, String> param){
        postRequest(param);l
    }*/

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }
}
