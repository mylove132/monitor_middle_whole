package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;
//创建和修改学生信息-家长

public class Api1_6 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("phone", param.get("phone"));
        json.put("reacode", param.get("reacode"));
        json.put("stuclasstype", param.get("stuclasstype"));
        json.put("studentid", param.get("studentid"));
        json.put("stugradeid", param.get("stugradeid"));
        json.put("stuname", param.get("stuname"));
        json.put("stusex", param.get("stusex"));
        json.put("stustageid", param.get("stustageid"));
        json.put("type", param.get("type"));
        json.put("role", param.get("role"));
        json.put("uid",account_uid);
        json.put("token",account_token);

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