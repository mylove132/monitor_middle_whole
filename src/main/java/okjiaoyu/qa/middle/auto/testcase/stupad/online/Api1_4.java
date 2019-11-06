package okjiaoyu.qa.middle.auto.testcase.stupad.online;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.4 上课提交答题接口
 */
public class Api1_4 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        getUnameValue(param.get("uname"), json);
        json.put("classid", param.get("classid"));
        json.put("courseid", param.get("courseid"));
        json.put("exeid", param.get("exeid"));

        JSONObject q1 = new JSONObject();
        String[] qid1 = {param.get("qid1"), param.get("qid1")};
        q1.put("qids", qid1);
        q1.put("qtype", Integer.parseInt(param.get("qtype")));
        q1.put("submitanswer", param.get("submitanswer"));
        q1.put("result", Integer.parseInt(param.get("result")));

//        JSONObject q2 = new JSONObject();
//        String[] qid2 = {"1404043", "1404043"};
//        q2.put("qids",qid2);
//        q2.put("qtype",1);
//        q2.put("submitanswer","C");
//        q2.put("result",2);

        JSONArray array = new JSONArray();
        array.add(q1);
//        array.add(q2);

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
