package okjiaoyu.qa.middle.auto.testcase.stupad.hardware;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong on 2018/10/12.
 *
 * 4.2知识点报告页统计个数和正确率
 */
public class Api1_5 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("ktype", param.get("ktype"));
        json.put("kid", param.get("kid"));
        json.put("klevel", param.get("klevel"));
        json.put("type", param.get("type"));
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
