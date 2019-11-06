package okjiaoyu.qa.middle.auto.testcase.privateweb.orderManagement;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 订单管理2.0--订单列表
 * Created by zhangchenglin on 2019/04/10.
 */
public class Api1_11 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
//        getRequestParams.add(new BasicNameValuePair("deliver_type", param.get("deliver_type")));
//        getRequestParams.add(new BasicNameValuePair("order_type_id", param.get("order_type_id")));
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
