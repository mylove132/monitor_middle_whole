package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.cart;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;
/**
 * 删除购物车商品
 * Created by shenbingbing 2019/01/29
 */
public class Api1_2 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("cartId", param.get("cartId"));
     json.put("handle", param.get("handle"));
     json.put("token", account_token);
     json.put("systemId", account_uid);
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
