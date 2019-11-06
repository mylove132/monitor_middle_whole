package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * shenbingbing add 2019/06/13
 * 扫码获取学生信息
 */

public class Api2_6 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("ticket", param.get("ticket"));
        json.put( "uid",account_uid );
        json.put("token",account_token );
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