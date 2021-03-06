package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.pay;

import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取支付方式列表
 * Created by shenbingbing 2019/05/10
 */
public class Api1_5 extends Mallh5_parent {
    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
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
