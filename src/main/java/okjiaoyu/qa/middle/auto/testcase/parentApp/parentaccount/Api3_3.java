package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

//删除（学生）帐号

public class Api3_3 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("token", account_token);
        json.put("uid", account_uid);
        json.put("studentid", param.get("studentid"));
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