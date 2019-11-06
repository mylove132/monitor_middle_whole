//package okjiaoyu.qa.middle.auto.testcase.crm;
//
//import com.alibaba.fastjson.JSONObject;
//import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
//import okjiaoyu.qa.tools.APIHttpClient;
//
//
///**
// * crm后台的登录
// */
//public class Crm_LoginOut extends Crm {
//
//    public void loginout() {
//        requestSampler.setType(0);//更新cookies，不属于测试用例
//        requestSampler.setRequestUrl(getInterfaceUrl());
//        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
//        APIHttpClient apiHttpClient = new APIHttpClient();
//        apiHttpClient.setCookies();
////        apiHttpClient.postFormdata(requestSampler);
//        apiHttpClient.getRequest(requestSampler);
//    }
//}
