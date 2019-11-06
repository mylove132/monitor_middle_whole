/*
package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.order;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;

*/
/**
 * 订单提交数据（由于此接口，做了次数限制，频繁提交，会提示异常，暂时不进行监控）
 * Created by shenbingbing 2019/01/25
 *//*

public class Api1_6 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("isCarts", param.get("isCarts"));
     json.put("goodsCnt", param.get("goodsCnt"));
     json.put("goodsId", param.get("goodsId"));
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
*/
