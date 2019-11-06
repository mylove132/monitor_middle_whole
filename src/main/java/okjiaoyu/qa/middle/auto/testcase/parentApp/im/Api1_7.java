package okjiaoyu.qa.middle.auto.testcase.parentApp.im;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.im;
import com.alibaba.fastjson.JSONObject;

import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;
*/
/**
 * shenbingbing add 2019/01/26
 * 发送 Im 消息
 *
 * 此业务已经下线,接口废弃1
 *//*

public class Api1_7 extends ParentApp_parent {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("extras", param.get("extras"));
        json.put("msg", param.get("msg"));
        json.put("title", param.get("title"));
        json.put("uids", param.get("uids"));
        json.put("url", param.get("url"));
        json.put("url_text", param.get("url_text"));
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
