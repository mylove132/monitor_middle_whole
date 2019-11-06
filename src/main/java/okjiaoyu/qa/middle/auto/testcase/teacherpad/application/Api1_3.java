package okjiaoyu.qa.middle.auto.testcase.teacherpad.application;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.RomTeacherPad;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * 线上监控rom版本升级
 * <p>
 * Created by chaozhe on 2017/6/12.
 */

public class Api1_3 extends RomTeacherPad {


    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("systemid", param.get("systemid"));
        jsonObject.put("token", param.get("token"));
        jsonObject.put("ua", param.get("ua"));
        jsonObject.put("sn", param.get("sn"));

        ArrayList<String> sidlist = new ArrayList<>();
        sidlist.add(param.get("sidlist"));
        jsonObject.put("sidlist", sidlist);


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
