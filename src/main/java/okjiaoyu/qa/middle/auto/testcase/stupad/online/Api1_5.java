package okjiaoyu.qa.middle.auto.testcase.stupad.online;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.5 主观题批改接口
 */
public class Api1_5 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        String[] qid1 = {param.get("qid1"), param.get("qid1")};
        json.put("qids", qid1);
        json.put("qtype", Integer.parseInt(param.get("qtype")));
        json.put("currentpage", param.get("currentpage"));
        json.put("exeid", param.get("exeid"));
        json.put("classid", param.get("classid"));
        json.put("courseid", param.get("courseid"));
        json.put("result", param.get("result"));
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
