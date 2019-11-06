/*
package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.cart;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;

*/
/*
 * 全选、反选(订单异常做了，清空购物车商品处理，线上不监控)
 * Created by shenbingbing 2019/01/29
 *//*

public class Api1_4 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("checkedAll", param.get("checkedAll"));
     json.put("checked", param.get("checked"));
     json.put("token", account_token);
     json.put("systemId", account_uid);
     json.put("handle", param.get("handle"));

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
*/
