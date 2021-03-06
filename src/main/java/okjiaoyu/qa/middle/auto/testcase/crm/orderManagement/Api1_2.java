package okjiaoyu.qa.middle.auto.testcase.crm.orderManagement;


import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单管理--订单列表动态检索条件
 * Created by zhangchenglin on 2019/04/10
 */
public class Api1_2 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {

        List<NameValuePair> getRequestParams = new ArrayList<>();
        Map entity = new HashMap();
        //parms
//        getRequestParams.add(new BasicNameValuePair("proId", param.get("proId")));        requestSampler.setGetRequsetParams(getRequestParams);
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
