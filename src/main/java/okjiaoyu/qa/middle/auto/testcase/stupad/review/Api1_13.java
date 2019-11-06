package okjiaoyu.qa.middle.auto.testcase.stupad.review;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2017/7/11.
 * for interface 2.1 apiRequest
 * 1.13 英语作文智批改详情接口
 */
public class Api1_13 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("qid", param.get("qid"));
        json.put("workid", param.get("workid"));
        json.put("module", Integer.parseInt(param.get("module")));
        json.put("resource_id", Integer.parseInt(param.get("resource_id")));
        json.put("wrongfrom", Integer.parseInt(param.get("wrongfrom")));
        json.put("isWrongBook", Integer.parseInt(param.get("isWrongBook")));
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
