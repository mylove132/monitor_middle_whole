package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/12.
 * for interface 2.1 apiRequest
 * 1.5 [自主学习][错题本]--做错题
 */
public class Api1_5 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("kid", param.get("kid"));
        json.put("klevel", Integer.parseInt(param.get("klevel")));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("sid", param.get("sid"));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
        json.put("seq", param.get("seq"));
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
