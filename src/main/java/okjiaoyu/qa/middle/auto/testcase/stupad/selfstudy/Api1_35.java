package okjiaoyu.qa.middle.auto.testcase.stupad.selfstudy;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by peidongdong on 2018/1/24.
 * for interface 2.1 apiRequest
 * 1.35 [自主学习]-- 知识点相关微课列表(智慧学习4.1新增)
 */
public class Api1_35 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("iccid", param.get("iccid"));
        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("sorttype", Integer.parseInt(param.get("sorttype")));
        json.put("kid", param.get("kid"));
        json.put("klevel", Integer.parseInt(param.get("klevel")));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
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
