package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.coupon;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * shenbingbing add
 * 优惠券列表
 */
public class Api1_1 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("page", param.get("page"));
        json.put( "page_size",param.get("page_size"));
        json.put( "phone",param.get("phone"));
        json.put( "user_coupon_status",param.get("user_coupon_status"));
        json.put( "token",account_token);
        json.put( "uid",account_uid);
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

}