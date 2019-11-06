//package okjiaoyu.qa.middle.auto.testcase.privateweb.tradeManagement;
//
//import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 订单列表-订单列表
// * Created by zhangchenglin on 2018/5/17.
// */
//public class Api1_11 extends PrivateWeb {
//
//    @Override
//    public void getParams(Map<String, String> param) {
//        List<NameValuePair> getRequestParams = new ArrayList<>();
//        //parms
//        getRequestParams.add(new BasicNameValuePair("day", param.get("day")));
//        getRequestParams.add(new BasicNameValuePair("key_type", param.get("key_type")));
//        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
//        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
//        getRequestParams.add(new BasicNameValuePair("keyword", param.get("keyword")));
//        getRequestParams.add(new BasicNameValuePair("price_end", param.get("price_end")));
//        getRequestParams.add(new BasicNameValuePair("price_start", param.get("price_start")));
//        getRequestParams.add(new BasicNameValuePair("order_source", param.get("order_source")));
//
//
//        requestSampler.setGetRequsetParams(getRequestParams);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        getRequest(param);
//    }
//
//}
