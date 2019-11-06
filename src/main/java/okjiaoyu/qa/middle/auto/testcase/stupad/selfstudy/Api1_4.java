package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/12.
 * for interface 2.1 apiRequest
 * 1.4 [自主学习]--知识点相关资源
 */
public class Api1_4 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("kid", param.get("kid"));
        json.put("klevel", Integer.parseInt(param.get("klevel")));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("type", Integer.parseInt(param.get("type")));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
        json.put("syncrestype", Integer.parseInt(param.get("syncrestype")));
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
