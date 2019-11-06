package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.pay;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * IOS支付验证
 * Created by shenbingbing 2019/05/10
 */
public class Api1_1 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("orderId", param.get("orderId"));
     json.put("token", account_token);
     json.put("systemId", account_uid);
     json.put("productId", param.get("productId"));
     json.put("receiptData", param.get("receiptData"));
     json.put("transactionId", param.get("transactionId"));
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
