package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.common;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.common;


import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;


 */
/**shenbingbing add
 * 苹果IAP请求商城生成订单(废弃)
*
*//*

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

public class Api1_5 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("buystatus", param.get("buystatus"));
        json.put( "roletype",param.get("roletype"));
        json.put( "viptype",param.get("viptype"));
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
*/
