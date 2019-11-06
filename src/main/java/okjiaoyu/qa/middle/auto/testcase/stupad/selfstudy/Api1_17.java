package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/12.
 * for interface 2.1 apiRequest
 * 1.17 [自主学习]--查看资源上报
 */
public class Api1_17 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("kid", param.get("kid"));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("klevel", Integer.parseInt(param.get("klevel")));
        json.put("resid", param.get("resid"));
        json.put("sid", param.get("sid"));
        json.put("type", Integer.parseInt(param.get("type")));
        json.put("restype", Integer.parseInt(param.get("restype")));
        json.put("duration", Long.parseLong(param.get("duration")));
        json.put("micduation", Long.parseLong(param.get("micduation")));
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
