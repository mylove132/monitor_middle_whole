package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/8/11.
 * for interface 2.1 apiRequest
 * 1.14 [自主学习]--提交求助
 */
/*
public class Api1_14 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param){
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("kid",param.get("kid"));
        json.put("klevel",Integer.parseInt(param.get("klevel")));
        json.put("time",param.get("time"));
        json.put("ktype",param.get("ktype"));
        json.put("date",param.get("date"));
        json.put("secondservice",Boolean.parseBoolean(param.get("secondservice")));
        return json.toJSONString();
    }


    @Test(dataProvider = "providerMethod", groups = { "normal" })
    public void test(Map<String, String> param){
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = { "exception" })
    public void exceptionTest(Map<String, String> param){
        postRequest(param);
    }

}
*/
