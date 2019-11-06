package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * shenbingbing add 2019/03/21
 * 用户修改个人信息（v2.9.1+）
 */

public class Api2_1 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("role", param.get("role"));
        json.put("uid",account_uid);
        json.put("token",account_token);
        Map<String,String> map=new HashMap<>(  );
        map.put( "name" ,param.get("name"));
        map.put( "reacode" ,param.get("reacode"));
        json.put( "user_info",map );
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