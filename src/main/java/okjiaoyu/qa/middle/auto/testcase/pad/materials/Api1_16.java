package okjiaoyu.qa.middle.auto.testcase.pad.materials;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.16 学科资源列表
 */
public class Api1_16 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        //params from xml
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        //answer datas
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("sid", param.get("sid"));
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
