package okjiaoyu.qa.middle.auto.testcase.platformresource.login;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.platformresource.PlatformResource;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//退出

public class Api1_2 extends PlatformResource {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }


}