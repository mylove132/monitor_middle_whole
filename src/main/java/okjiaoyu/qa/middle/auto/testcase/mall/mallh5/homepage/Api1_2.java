package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.homepage;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * 获取商品信息列表
 * Created by shenbingbing 2019/01/29
 */
public class Api1_2 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("pageNo", param.get("pageNo"));
     json.put("channelType", param.get("channelType"));
     json.put("pageSize", param.get("pageSize"));
     json.put("categoryCode", param.get("categoryCode"));
     json.put("searchFlag", param.get("searchFlag"));
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
