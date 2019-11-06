package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.order;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import okjiaoyu.qa.tools.RunningParameter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 取消订单
 * Created by shenbingbing 2019/01/25
 */
public class Api1_1 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("orderId", param.get("orderId"));
     json.put("token", account_token);
     json.put("systemId", account_uid);
     json.put("userName", param.get("userName"));
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
