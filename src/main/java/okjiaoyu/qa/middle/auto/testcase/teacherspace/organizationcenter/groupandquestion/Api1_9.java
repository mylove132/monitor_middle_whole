//package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.groupandquestion;
//
//import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.*;
//
///**
// * Created by leo on 16/1/15. 新增分组
// */
//public class Api1_9 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param){
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
////        Date date = new Date();
////        String name = param.get("name") + date;
////        getRequestParms.add(new BasicNameValuePair("name", name));
//        getRequestParms.add(new BasicNameValuePair("name",param.get("name")));
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
