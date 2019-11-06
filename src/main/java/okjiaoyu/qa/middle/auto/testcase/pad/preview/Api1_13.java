package okjiaoyu.qa.middle.auto.testcase.pad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2016/11/30.
 * for interface 2.1 apiRequest
 * 1.13 预习章节获取资源列表
 */
public class Api1_13 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("cid", param.get("cid"));
        json.put("restype", param.get("restype"));
        json.put("cpage", Integer.parseInt(param.get("cpage")));
        json.put("psize", Integer.parseInt(param.get("psize")));
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
