package okjiaoyu.qa.middle.auto.testcase.privateweb.authorityManagement;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 权限管理-更多名单列表
 * Created by zhangchenglin on 2018/8/27.
 */
public class Api1_3 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParams.add(new BasicNameValuePair("name", param.get("name")));
        requestSampler.setGetRequsetParams(getRequestParams);
    }

    //@Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    //@Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
