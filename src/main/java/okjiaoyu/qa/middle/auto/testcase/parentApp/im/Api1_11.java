package okjiaoyu.qa.middle.auto.testcase.parentApp.im;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * shenbingbing add 2019/02/19
 * 修改语音已读和未读
 */
public class Api1_11 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put("msgIds", param.get("msgIds"));
        json.put("type", param.get("type"));
        json.put("uid", account_uid);
        return json.toJSONString();
    }
    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestByJsonUtil(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestByJsonUtil(param);
    }

}