package okjiaoyu.qa.middle.auto.testcase.pad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2016/11/30.
 * for interface 2.1 apiRequest
 * 1.12 分册列表
 */
public class Api1_12 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("sid", Integer.parseInt(param.get("sid")));
        //json.put("syid", Integer.parseInt(param.get("syid")));
        //json.put("currentpage", Integer.parseInt(param.get("currentpage")));
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
