package okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import okjiaoyu.qa.tools.APIHttpClient;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaozhe on 2017/6/12.
 */
public class Teacherpad_Login extends TeacherPad {


    public void login() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uname", loginUser);
        jsonObject.put("pwd", password);
        String response = new APIHttpClient().executePostRequest(getInterfaceUrl(), jsonObject, "987");
        JSONObject responseJson = JSONObject.parseObject(response);
        //去teacherpad中保存uid和token
        account_token = responseJson.getJSONObject("data").get("token").toString();
        account_uid = responseJson.getJSONObject("data").get("uid").toString();

        System.out.println("登陆的response:" + responseJson.toJSONString());
    }

}
