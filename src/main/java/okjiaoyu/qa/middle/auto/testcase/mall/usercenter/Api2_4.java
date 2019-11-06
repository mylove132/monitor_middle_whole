//package okjiaoyu.qa.middle.auto.testcase.mall.usercenter;
//
//import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * 获取短信验证码，增加了图形验证码
// * Created by leo on 17/7/4.
// */
//public class Api2_4 extends Mall {
//    @Override
//    public void getParams(Map<String, String> param) {
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
//        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
//        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
//        getRequestParms.add(new BasicNameValuePair("userPhone", param.get("userPhone")));
//
//        requestSampler.setGetRequsetParams(getRequestParms);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        getRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//        getRequest(param);
//    }
//}
