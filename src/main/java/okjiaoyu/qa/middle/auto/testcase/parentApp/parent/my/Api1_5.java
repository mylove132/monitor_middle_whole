package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.my;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * shenbingbing add
 * Okay+ ios&android是否升级
 */
public class Api1_5 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("apppkg", param.get("apppkg"));
        json.put("token", account_token);
        json.put("uid", account_uid);
      /*  json.put("ua", param.get("ua"));*/
        json.put("vc", param.get("vc"));
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