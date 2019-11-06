package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.address;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.testng.annotations.Test;

import java.util.Map;
/**
 * 地址-修改 收货地址
 * Created by shenbingbing 2019/01/29
 */
public class Api1_3 extends Mallh5_parent {
 @Override
 public String getRequestJsonString(Map<String, String> param) {
     JSONObject json = new JSONObject();
     json.put("defaultFlag", param.get("defaultFlag"));
     json.put("address", param.get("address"));
     json.put("areaCode", param.get("areaCode"));
     json.put("provinceCode", param.get("provinceCode"));
     json.put("cityCode", param.get("cityCode"));
     json.put("name", param.get("name"));
     json.put("tel", param.get("tel"));
     json.put("type", param.get("type"));
     json.put("provinceName", param.get("provinceName"));
     json.put("cityName", param.get("cityName"));
     json.put("areaName", param.get("areaName"));
     json.put("createTime", param.get("createTime"));
     json.put("updateTime", param.get("updateTime"));
     json.put("id", param.get("id"));
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
