//package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.uploadresources;
//
//import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
//import org.testng.annotations.Test;
//
//import java.util.Map;
//
///**
// * Created by leo on 17/5/25.获取上传的题集详情
// */
//public class Api1_5 extends TeacherSpace {
//
//    @Override
//    public void getParams(Map<String, String> param){
//        requestSampler.getFormValuePairs().put("question_ids", param.get("question_ids"));
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//                    postFormRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postFormRequest(param);
//    }
//
//}
