package okjiaoyu.qa.middle.auto.testcase.pad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shen on 2016/11/30.
 * for interface 2.1 apiRequest
 * 1.9 按章节自主预习推送资源（2.4新增）
 */
public class Api1_9 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        //json.put("pid", param.get("pid"));
        json.put("sid", param.get("sid"));
        json.put("cid", param.get("cid"));
        //json.put("timeout", Boolean.parseBoolean(param.get("timeout")));
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
