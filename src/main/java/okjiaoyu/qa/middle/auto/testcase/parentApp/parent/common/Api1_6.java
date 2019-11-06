package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.common;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 *  * shenbingbing add
 *  * 微课点击上报
 */
public class Api1_6 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("role", param.get("role"));
        json.put("duration", param.get("duration"));
        json.put("kid", param.get("kid"));
        json.put("klevel", param.get("klevel"));
        json.put("ktype", param.get("ktype"));
        json.put("sid", param.get("sid"));
        json.put("type", param.get("type"));
        json.put("uid", account_uid);
        json.put("token", account_token);
        json.put("micduation", param.get("micduation"));
        json.put("refereeid", param.get("refereeid"));
        json.put("resid", param.get("resid"));
        json.put("restype", param.get("restype"));
        json.put("scene", param.get("scene"));
        json.put("stayduration", param.get("stayduration"));
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
