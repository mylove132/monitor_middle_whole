package okjiaoyu.qa.middle.auto.testcase.parentApp.usercenter;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.usercenter;

import com.alibaba.fastjson.JSONObject;

import org.testng.annotations.Test;

import java.util.Map;

*/
/**
 * shenbingbing 2019/02/15
 * 家长创建学生（不进行提交）
 *//*


public class Api1_1 extends ParentApp {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("token", account_token);
        json.put("uid", account_uid);
        json.put("reaCode", param.get("reaCode"));
        json.put("stuClassType", param.get("stuClassType"));
        json.put("stuGradeId", param.get("stuGradeId"));
        json.put("stuName", param.get("stuName"));
        json.put("stuSex", param.get("stuSex"));
        json.put("stuStageId", param.get("stuStageId"));
        json.put("userType", param.get("userType"));
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
