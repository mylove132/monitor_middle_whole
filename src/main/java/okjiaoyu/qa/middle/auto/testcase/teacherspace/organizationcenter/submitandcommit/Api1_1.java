//package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.submitandcommit;
//
//import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
////获取题集的发布信息
////接口废弃
//public class Api1_1 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param) {
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
//        getRequestParms.add(new BasicNameValuePair("publish_id", param.get("publish_id")));
//        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));
//        getRequestParms.add(new BasicNameValuePair("link_id", param.get("link_id")));
//        getRequestParms.add(new BasicNameValuePair("resource_id", param.get("resource_id")));
//        requestSampler.setGetRequsetParams(getRequestParms);
//
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        getRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//    //@Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        getRequest(param);
//    }
//
//    //@Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        getRequest(param);
//    }
//
//}
