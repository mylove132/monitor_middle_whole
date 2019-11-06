package okjiaoyu.qa.middle.auto.testcase.stupad.preview;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/11.
 * for interface 2.1 apiRequest
 * 1.4课前预习提交答案
 */
public class Api1_4 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("workid", param.get("workid"));
        json.put("duration", Long.parseLong(param.get("duration")));

        JSONObject q1 = new JSONObject();
        String[] qid1 = {param.get("qid1"), param.get("qid1")};
        q1.put("qids", qid1);
        q1.put("qtype", 4);
        q1.put("submitanswer", "B");
        q1.put("result", 6);
        q1.put("structid", "1");

        JSONArray array = new JSONArray();
        array.add(q1);
        //array.add(q2);

        json.put("qanswers", array);

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
