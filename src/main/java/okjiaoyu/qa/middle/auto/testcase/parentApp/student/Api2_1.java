package okjiaoyu.qa.middle.auto.testcase.parentApp.student;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * shenbingbing add
 * 专栏下发表留言[√]zmq
 */

public class Api2_1 extends ParentApp_student {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("content", param.get("content"));
        json.put("role", param.get("role"));
        json.put("talk_id", param.get("talk_id"));
        json.put("token", account_token);
        json.put("uid", account_uid);
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