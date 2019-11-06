package okjiaoyu.qa.middle.auto.testcase.pad.review;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.6 主观题批改接口 - 简答题 - 章节刷题
 */
public class Api1_6 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        //answer datas
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("workid", param.get("workid"));
        json.put("flag", Long.parseLong(param.get("flag")));
        json.put("from", Long.parseLong(param.get("from")));

        JSONObject q1 = new JSONObject();
        String[] qid1 = {param.get("qid"), param.get("qid")};
        q1.put("qids", qid1);
        q1.put("qtype", Integer.parseInt(param.get("qtype")));
        q1.put("result", Integer.parseInt(param.get("result")));

        JSONArray array = new JSONArray();
        array.add(q1);

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
