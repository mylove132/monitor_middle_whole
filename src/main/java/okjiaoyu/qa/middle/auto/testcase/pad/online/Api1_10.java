package okjiaoyu.qa.middle.auto.testcase.pad.online;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.10 获取课程资源列表
 */
public class Api1_10 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getUidValue(param.get("uid"), json);
        getTokenValue(param.get("token"), json);
        json.put("courseid", param.get("courseid"));
        json.put("classid", param.get("classid"));
        json.put("pagesize", param.get("pagesize"));
        json.put("currentpage", param.get("currentpage"));
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
