package okjiaoyu.qa.middle.auto.testcase.crm.applicationCenter;

import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 版本升级管理--获取版本对应应用信息
 * Created by zhangchenglin on 2018/8/28.
 */
public class Api1_7 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("id", param.get("id")));
        getRequestParams.add(new BasicNameValuePair("type", param.get("type")));

        requestSampler.setGetRequsetParams(getRequestParams);
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
