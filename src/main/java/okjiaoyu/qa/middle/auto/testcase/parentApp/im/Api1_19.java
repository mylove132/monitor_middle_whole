package okjiaoyu.qa.middle.auto.testcase.parentApp.im;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * shenbingbing add 2019/02/19
 * 获取小米token
 */
public class Api1_19 extends ParentApp_parent {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        getRequestParams.add(new BasicNameValuePair("uid", account_uid));
        requestSampler.setGetRequsetParams(getRequestParams);
    }
    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequestUtil(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequestUtil(param);
    }

}