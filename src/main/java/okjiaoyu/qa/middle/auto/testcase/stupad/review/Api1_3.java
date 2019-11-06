package okjiaoyu.qa.middle.auto.testcase.stupad.review;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/11.
 * for interface 2.1 apiRequest
 * 1.3 作业提交答案
 */
public class Api1_3 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        //params from xml
        requestSampler.setTestCaseName(param.get("testcaseName"));
        requestSampler.setExpectedCode(param.get("expectedCode"));
        //answer datas
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("workid", param.get("workid"));
        json.put("duration", Long.parseLong(param.get("duration")));

        JSONObject q1 = new JSONObject();
        String[] qid1 = {param.get("qid1")};
        q1.put("qids", qid1);
        q1.put("qtype", 1);
        q1.put("submitanswer", "B");
        q1.put("result", 1);
        q1.put("intelligent", param.get("intelligent"));
        q1.put("structid", param.get("structid"));
        /*JSONObject q2 = new JSONObject();
        String[] qid2 = {param.get("qid2"), param.get("qid2")};
        q2.put("qids",qid2);
        q2.put("qtype",1);
        q2.put("submitanswer","B");
        q2.put("result",6);*/

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
