package okjiaoyu.qa.middle.auto.testcase.privateweb.tradeManagement;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 平台后台商品管理-商品列表展示
 * Created by zhangchenglin on 2018/5/17.
 */
public class Api1_8 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("act", param.get("act")));
        getRequestParams.add(new BasicNameValuePair("day_start", param.get("day_start")));
        getRequestParams.add(new BasicNameValuePair("day_end", param.get("day_end")));
        getRequestParams.add(new BasicNameValuePair("ksu_status", param.get("ksu_status")));
        getRequestParams.add(new BasicNameValuePair("key_type", param.get("key_type")));
        getRequestParams.add(new BasicNameValuePair("teacher_id", param.get("teacher_id")));
        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParams.add(new BasicNameValuePair("keyword", param.get("keyword")));
        getRequestParams.add(new BasicNameValuePair("price_start", param.get("price_start")));
        getRequestParams.add(new BasicNameValuePair("price_end", param.get("price_end")));

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
