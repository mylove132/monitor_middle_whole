package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.common;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.common;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

*/
/**
 * shenbingbing add
 * 根据订单号查询商品ID（废弃）
 *//*

public class Api1_4 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("order_id", param.get("order_id"));
        return json.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestByJson(param);
    }


    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestByJson(param);
    }

}*/
