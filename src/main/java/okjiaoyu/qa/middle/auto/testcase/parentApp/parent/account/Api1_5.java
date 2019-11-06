package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.account;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
/**
 * shenbingbing add 2019/01/27
 * 关联学生
 */
public class Api1_5 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        Map<String,String> map=new HashMap<>(  );
        map.put( "studentid",param.get("studentid") );
        map.put( "studentpwd",param.get("studentpwd") );
        map.put( "token",account_token );
        map.put( "uid",account_uid );
        JSONObject json = new JSONObject();
        String role= param.get("role");
        logger.info( role );
        json.put("role", role);
        json.put( "parme",map);
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
