package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.column;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.column;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

*/
/**
 * shenbingbing add 2019/01/26
 * 专栏下发表留言[√]zmq--产品反馈，造成的测试数据，影响运营人员的判断，暂时屏蔽；
 *//*

public class Api1_4 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put( "content",param.get("content"));
        json.put( "role",param.get("role"));
        json.put( "talk_id",param.get("talk_id"));
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

}*/
