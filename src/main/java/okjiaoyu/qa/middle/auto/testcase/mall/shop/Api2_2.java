package okjiaoyu.qa.middle.auto.testcase.mall.shop;

import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.tools.RunningParameter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 提交生成订单
 * Created by leo on 17/6/29.
 */
public class Api2_2 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("mall_token", RunningParameter.mall_token));
        getRequestParms.add(new BasicNameValuePair("m", param.get("m")));
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
//        getRequestParms.add(new BasicNameValuePair("callback", param.get("callback")));
//        getRequestParms.add(new BasicNameValuePair("invoice", param.get("invoice")));
//        getRequestParms.add(new BasicNameValuePair("invoiceTitle", param.get("invoiceTitle")));
        getRequestParms.add(new BasicNameValuePair("addressId", param.get("addressId")));
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
