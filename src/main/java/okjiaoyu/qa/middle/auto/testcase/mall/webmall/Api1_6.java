package okjiaoyu.qa.middle.auto.testcase.mall.webmall;

import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提交订单
 * Created by leo on 17/7/4.
 */
public class Api1_6 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("m", param.get("m")));
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
        getRequestParms.add(new BasicNameValuePair("consigneeId", param.get("consigneeId")));
        getRequestParms.add(new BasicNameValuePair("invoiceClient", param.get("invoiceClient")));
        getRequestParms.add(new BasicNameValuePair("needreceipt", param.get("needreceipt")));
        getRequestParms.add(new BasicNameValuePair("payway", param.get("payway")));
        getRequestParms.add(new BasicNameValuePair("studentId", param.get("studentId")));
        getRequestParms.add(new BasicNameValuePair("remarks", param.get("remarks")));

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
