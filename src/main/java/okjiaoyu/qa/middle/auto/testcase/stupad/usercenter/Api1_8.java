package okjiaoyu.qa.middle.auto.testcase.stupad.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/7.
 * for interface 2.1 apiRequest
 * 1.8 意见反馈
 */
public class Api1_8 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("content", param.get("content"));
        json.put("contact", param.get("contact"));
        json.put("type", param.get("type"));
        json.put("needreply", param.get("needreply"));
        return json.toJSONString();
    }


    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequest(param);
    }

}


