package okjiaoyu.qa.middle.auto.testcase.privateweb.orderManagement;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 订单管理2.1--订单信息
 * Created by zhangchenglin on 2019/04/10.
 */
public class Api1_19 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
//        getRequestParams.add(new BasicNameValuePair("deliver_type", param.get("deliver_type")));
        getRequestParams.add(new BasicNameValuePair("id", param.get("id")));
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
