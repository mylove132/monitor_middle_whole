/*
package okjiaoyu.qa.middle.auto.testcase.mall.usercenter;

import okjiaoyu.qa.middle.auto.testcase.mall.Mall;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * 家长创建学生
 * Created by leo on 2019/02/15  只进行测试，暂不上传git
 *//*

public class Api2_7 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
        getRequestParms.add(new BasicNameValuePair("verifyTel", param.get("verifyTel")));
        getRequestParms.add(new BasicNameValuePair("comfirmPassword", param.get("comfirmPassword")));
        getRequestParms.add(new BasicNameValuePair("password", param.get("password")));
        getRequestParms.add(new BasicNameValuePair("protocol", param.get("protocol")));
        getRequestParms.add(new BasicNameValuePair("regcode", param.get("regcode")));

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

    ParentApp parentApp = new ParentApp();

    public ParentApp getParentApp() {
        return parentApp;
    }
}
*/
