package okjiaoyu.qa.middle.auto.testcase.parentApp.student.account;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

//家长账号密码登陆-默认执行接口前,会调用登录，此接口暂不进行单独执行

public class Api1_4 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        Map<String,String> map=new HashMap<>(  );
        map.put( "type",param.get("type") );
        map.put( "account",account_uname);
        map.put( "pwd",account_pwd);
        JSONObject json = new JSONObject();
        json.put("role", param.get("role"));
        json.put( "type",map);
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
