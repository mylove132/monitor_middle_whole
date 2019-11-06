package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by peidongdong on 2018/1/24.
 * for interface 2.1 apiRequest
 * 1.23 [自主学习]--学科对应知识点列表（学情指南新增）
 */
public class Api1_23 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("sid", Integer.parseInt(param.get("sid")));
        json.put("type", Integer.parseInt(param.get("type")));
        json.put("timespan", Integer.parseInt(param.get("timespan")));
        json.put("bookid", param.get("bookid"));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
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
