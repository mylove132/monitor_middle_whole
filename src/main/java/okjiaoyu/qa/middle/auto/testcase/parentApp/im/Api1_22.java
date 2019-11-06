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
 * 获取聊天历史记录
 */
public class Api1_22 extends ParentApp_parent {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        getRequestParams.add(new BasicNameValuePair("count", param.get("count")));
        getRequestParams.add(new BasicNameValuePair("fromAccount", account_uid));
        getRequestParams.add(new BasicNameValuePair("im_token", param.get("im_token")));
        getRequestParams.add(new BasicNameValuePair("toAccount", account_uid));
        getRequestParams.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParams.add(new BasicNameValuePair("utcToTime", param.get("utcToTime")));
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