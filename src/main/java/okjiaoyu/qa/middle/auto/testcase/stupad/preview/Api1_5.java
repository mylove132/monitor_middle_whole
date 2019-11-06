package okjiaoyu.qa.middle.auto.testcase.stupad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/11.
 * for interface 2.1 apiRequest
 * 1.5 预习历史列表
 */
public class Api1_5 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("sid", param.get("sid"));
        json.put("syid", param.get("syid"));
        json.put("cp", Integer.parseInt(param.get("cp")));
        json.put("ps", Integer.parseInt(param.get("ps")));
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
