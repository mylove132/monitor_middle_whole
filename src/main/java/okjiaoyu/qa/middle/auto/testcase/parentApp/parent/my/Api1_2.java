package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.my;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;
/**
 * shenbingbing add
 * 我学会的知识点(只有学生账号存在此接口)
 */
public class Api1_2 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("page", param.get("page"));
        json.put("pagesize", param.get("pagesize"));
        json.put("sub_id", param.get("sub_id"));
        json.put("token",account_token);
        json.put("uid",account_uid);
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