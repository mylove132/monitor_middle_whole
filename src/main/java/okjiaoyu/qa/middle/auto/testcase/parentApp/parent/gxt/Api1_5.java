package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.gxt;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * shenbingbing add
 * 获取折线图
 */

public class Api1_5 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
       /* json.put("role", param.get("role"));*/
        json.put( "area_id",param.get("area_id"));
        json.put( "k_id",param.get("k_id"));
        json.put( "token",account_token);
        json.put( "uid",account_uid);
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