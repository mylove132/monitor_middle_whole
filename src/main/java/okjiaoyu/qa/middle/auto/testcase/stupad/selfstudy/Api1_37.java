package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by peidongdong on 2018/1/24.
 * for interface 2.1 apiRequest
 * 1.37 [自主学习]--查询资源是否停用
 */
public class Api1_37 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("iccid", param.get("iccid"));
        json.put("resId", Integer.parseInt(param.get("resId")));
        json.put("resType", Integer.parseInt(param.get("resType")));
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
