package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/12.
 * for interface 2.1 apiRequest
 * 1.8 [自主学习]--提交答题接口
 */
public class Api1_8 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("workid", param.get("workid"));
        json.put("kid", param.get("kid"));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("answertype", Integer.parseInt(param.get("answertype")));
        json.put("selecthelp", Boolean.parseBoolean(param.get("selecthelp")));

        JSONObject q1 = new JSONObject();
        String[] qid1 = {param.get("qid1"), param.get("qid1")};
        q1.put("qids", qid1);
        q1.put("qtype", 4);
        q1.put("submitanswer", "B");
        q1.put("result", 6);
        q1.put("submittype", 1);

//        JSONObject q2 = new JSONObject();
//        String[] qid2 = {param.get("qid2"), param.get("qid2")};
//        q2.put("qids",qid2);
//        q2.put("qtype",4);
//        q2.put("submitanswer","C");
//        q2.put("result",6);
//        q2.put("submittype",1);

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
