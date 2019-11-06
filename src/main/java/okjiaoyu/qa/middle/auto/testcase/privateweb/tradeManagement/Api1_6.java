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
// * 商品列表-商品状态变更
// * Created by zhangchenglin on 2018/5/17.
// */
//public class Api1_6 extends PrivateWeb {
//
//    @Override
//    public void getParams(Map<String, String> param) {
//        List<NameValuePair> getRequestParams = new ArrayList<>();
//        //parms
//        getRequestParams.add(new BasicNameValuePair("ksu_action", param.get("ksu_action")));
//        getRequestParams.add(new BasicNameValuePair("ksu_id", param.get("ksu_id")));
//        getRequestParams.add(new BasicNameValuePair("reason", param.get("reason")));
//        getRequestParams.add(new BasicNameValuePair("ksu_status", param.get("ksu_status")));
//
//        requestSampler.setGetRequsetParams(getRequestParams);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//        postRequest(param);
//    }
//
//}
