package okjiaoyu.qa.middle.auto.testcase.stupad.review;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/11.
 * for interface 2.1 apiRequest
 * 1.11 错题本获取题集
 */
public class Api1_11 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("id", param.get("id"));
        json.put("flag", Integer.parseInt(param.get("flag")));
        json.put("level", Integer.parseInt(param.get("level")));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
        json.put("fromindex", Integer.parseInt(param.get("fromindex")));
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
