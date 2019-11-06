package okjiaoyu.qa.middle.auto.testcase.stupad.hardware;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong on 2018/10/12.
 *
 * 5.3末级知识点资源详情接口
 */
public class Api1_8 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("currentpage", param.get("currentpage"));
        json.put("ktype", param.get("ktype"));
        json.put("kid", param.get("kid"));
        json.put("restype", param.get("restype"));
        json.put("resfilter", param.get("resfilter"));
        json.put("klevel", param.get("klevel"));
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
