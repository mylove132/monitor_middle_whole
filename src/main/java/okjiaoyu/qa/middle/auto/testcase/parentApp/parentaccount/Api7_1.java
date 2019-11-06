package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

//获取学生学习动态（1.2.0+）

public class Api7_1 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("token", account_token);
        json.put("uid", account_uid);
        json.put("childid", param.get("childid"));
        json.put("pagesize", param.get("pagesize"));
        json.put("searchid", param.get("searchid"));
        json.put("type", param.get("type"));
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