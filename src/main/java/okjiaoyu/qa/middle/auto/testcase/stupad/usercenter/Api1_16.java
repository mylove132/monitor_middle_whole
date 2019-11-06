package okjiaoyu.qa.middle.auto.testcase.stupad.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/7.
 * for interface 2.1 apiRequest
 * 1.16 重置密码
 */
public class Api1_16 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("uname", param.get("uname"));
        getPwdValue(param.get("pwd"), json, "pwd");
        json.put("verifycode", param.get("verifycode"));
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


