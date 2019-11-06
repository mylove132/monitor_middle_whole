package okjiaoyu.qa.middle.auto.testcase.pad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.7 课前预习资源打开上报
 */
public class Api1_7 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("pid", param.get("pid"));
        json.put("sid", param.get("sid"));
        json.put("stype", param.get("stype"));
        json.put("timeout", Boolean.parseBoolean(param.get("timeout")));
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
