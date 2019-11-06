package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.my;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.my;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * shenbingbing add
 * 我学会的-学科列表(此接口已经废弃了)
 *//*


public class Api1_4 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("page", param.get("page"));
        json.put("pagesize", param.get("pagesize"));
        json.put("token", account_token);
        json.put("uid", account_uid);
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

}*/
