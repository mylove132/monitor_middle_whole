package okjiaoyu.qa.middle.auto.testcase.privateweb.productCenter;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商品中心--查看会员操作记录
 * Created by zhangchenglin on 201903013.
 */
public class Api1_4 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("vip_type_id", param.get("vip_type_id")));
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
