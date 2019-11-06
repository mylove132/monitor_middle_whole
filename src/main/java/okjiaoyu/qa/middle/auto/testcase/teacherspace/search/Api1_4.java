//package okjiaoyu.qa.middle.auto.testcase.teacherspace.search;
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
///**
// * Created by leo on 17/1/15.  文库搜索
// */
//public class Api1_4 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param){
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
//        getRequestParms.add(new BasicNameValuePair("page", param.get("page")));
//        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
//        getRequestParms.add(new BasicNameValuePair("page_size", param.get("page_size")));
//        getRequestParms.add(new BasicNameValuePair("uid", param.get("uid")));
//        getRequestParms.add(new BasicNameValuePair("keyword", param.get("keyword")));
//        requestSampler.setGetRequsetParams(getRequestParms);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        getRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        getRequest(param);
//    }
//
//}
