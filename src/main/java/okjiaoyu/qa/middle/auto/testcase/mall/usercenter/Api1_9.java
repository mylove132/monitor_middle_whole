package okjiaoyu.qa.middle.auto.testcase.mall.usercenter;

import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.tools.RunningParameter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 修改地址
 * Created by leo on 17/7/4.
 */
public class Api1_9 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
        getRequestParms.add(new BasicNameValuePair("m", param.get("m")));
        getRequestParms.add(new BasicNameValuePair("email", param.get("email")));
        getRequestParms.add(new BasicNameValuePair("address", param.get("address")));
        getRequestParms.add(new BasicNameValuePair("areaId1", param.get("areaId1")));
        getRequestParms.add(new BasicNameValuePair("areaId2", param.get("areaId2")));
        getRequestParms.add(new BasicNameValuePair("areaId3", param.get("areaId3")));
        getRequestParms.add(new BasicNameValuePair("userName", param.get("userName")));
        getRequestParms.add(new BasicNameValuePair("userPhone", param.get("userPhone")));
        getRequestParms.add(new BasicNameValuePair("isDefault", param.get("isDefault")));
        getRequestParms.add(new BasicNameValuePair("id", param.get("id")));
        getRequestParms.add(new BasicNameValuePair("mall_token", RunningParameter.mall_token));

        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }
}
