package okjiaoyu.qa.middle.auto.testcase.pad.review;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

///**
// * Created by 晓 on 2015/7/9.
// * for interface 2.1 apiRequest
// * 1.19 查看知识点的求助状态详情
// */
public class Api1_19 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("id", param.get("id"));
        json.put("level", param.get("level"));
        return json.toJSONString();
    }


    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }
}
