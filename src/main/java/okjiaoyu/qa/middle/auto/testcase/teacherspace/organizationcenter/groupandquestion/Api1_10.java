//package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.groupandquestion;
//
//import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by leo on 16/1/15. 题目分组-移动题目的分组
// */
//public class Api1_10 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param){
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        //parms
//        getRequestParms.add(new BasicNameValuePair("question_id", param.get("question_id")));
//        getRequestParms.add(new BasicNameValuePair("group_id", param.get("group_id")));
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
