package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.address;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 地址-删除收货地址
 * Created by shenbingbing 2019/01/29
 */
public class Api1_1 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("addressIdList", param.get("addressIdList"));
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
