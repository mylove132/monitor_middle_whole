package okjiaoyu.qa.middle.auto.testcase.crm.productCenter;


import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品中心--获取会员选项
 * Created by zhangchenglin on 2018/11/14.
 */
public class Api1_3 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {

        List<NameValuePair> getRequestParams = new ArrayList<>();
        Map entity = new HashMap();
        //parms
        getRequestParams.add(new BasicNameValuePair("category_id", param.get("category_id")));
        getRequestParams.add(new BasicNameValuePair("org_id", param.get("org_id")));
        getRequestParams.add(new BasicNameValuePair("org_type", param.get("org_type")));
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
