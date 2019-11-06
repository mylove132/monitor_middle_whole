//package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;
//
//import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by leo on 16/1/17.  创建、更新并发布资源包
// */
//public class Api1_6 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param){
//        requestSampler.getFormValuePairs().put("resource_ids", param.get("resource_ids"));
//        requestSampler.getFormValuePairs().put("publish_name", param.get("publish_name"));
//        requestSampler.getFormValuePairs().put("type_publish", param.get("type_publish"));
//        requestSampler.getFormValuePairs().put("type_target", param.get("type_target"));
//        requestSampler.getFormValuePairs().put("class_ids", param.get("class_ids"));
//        requestSampler.getFormValuePairs().put("student_ids", param.get("student_ids"));
//        requestSampler.getFormValuePairs().put("end_time", param.get("end_time"));
//        requestSampler.getFormValuePairs().put("title", param.get("title"));
//        requestSampler.getFormValuePairs().put("system_id", param.get("system_id"));
//        requestSampler.getFormValuePairs().put("custom_directory_id", param.get("custom_directory_id"));
//
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
////        for(int i=0;i<=1000;i++) {
//            postFormRequest(param);
////        }
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postFormRequest(param);
//    }
//
//}
