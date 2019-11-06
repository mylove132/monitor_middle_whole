package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

//忘记密码

public class Api1_6 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("phone", param.get("phone"));
        json.put("newpwd", param.get("newpwd"));
        json.put("code", param.get("code"));
        json.put("traceno", param.get("traceno"));
        return json.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestByJson(param);
    }


    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestByJson(param);
    }

}