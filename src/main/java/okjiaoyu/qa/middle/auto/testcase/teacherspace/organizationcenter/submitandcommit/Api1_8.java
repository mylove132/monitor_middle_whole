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
///**
// * 批注
// */
////已废弃
//public class Api1_8 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param) {
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
//        getRequestParms.add(new BasicNameValuePair("publish_id", param.get("publish_id")));
//        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));
//        getRequestParms.add(new BasicNameValuePair("question_id", param.get("question_id")));
//        getRequestParms.add(new BasicNameValuePair("student_id", param.get("student_id")));
//        getRequestParms.add(new BasicNameValuePair("struct_id", param.get("struct_id")));
//        getRequestParms.add(new BasicNameValuePair("answer", param.get("answer")));
//        getRequestParms.add(new BasicNameValuePair("link_id", param.get("link_id")));
//        getRequestParms.add(new BasicNameValuePair("resource_id", param.get("resource_id")));
////        getRequestParms.add(new BasicNameValuePair("sub_question_id", param.get("sub_question_id")));
//        requestSampler.setGetRequsetParams(getRequestParms);
//    }
//
//<<<<<<< HEAD
//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        getRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = {"exception"})
//    public void exceptionTest(Map<String, String> param) {
//=======
//    //@Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        getRequest(param);
//    }
//
//    //@Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//>>>>>>> 58eb3147e2c167130138680aab02235ee5abecb6
//        getRequest(param);
//    }
//
//}
