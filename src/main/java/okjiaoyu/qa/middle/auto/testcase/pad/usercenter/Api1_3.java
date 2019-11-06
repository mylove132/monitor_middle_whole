package okjiaoyu.qa.middle.auto.testcase.pad.usercenter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.3 软件升级
 */
public class Api1_3 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("vcode", param.get("vcode"));
        json.put("pkgname", param.get("pkgname"));
        return json.toJSONString();
    }

//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postRequest(param);
//    }

}
