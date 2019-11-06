package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * shenbingbing add 2019/06/13
 * 扫码关联学生(暂时不进行测试)
 *//*


public class Api2_5 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        Map<String,String> map=new HashMap<>(  );
        map.put( "uid",account_uid );
        map.put("token",account_token );
        JSONObject json = new JSONObject();
        json.put("parame",map);
        json.put("ticket", param.get("ticket"));
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
