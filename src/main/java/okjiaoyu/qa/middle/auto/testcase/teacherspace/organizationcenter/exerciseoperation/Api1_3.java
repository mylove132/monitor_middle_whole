package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.exerciseoperation;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/17. 保存并发布题集   -监控异常
 */
public class Api1_3 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("title", param.get("title")));
//        getRequestParms.add(new BasicNameValuePair("chapter_id", param.get("chapter_id")));
        getRequestParms.add(new BasicNameValuePair("resource_ids", param.get("resource_ids")));
//        getRequestParms.add(new BasicNameValuePair("question_ids", param.get("question_ids")));
//        getRequestParms.add(new BasicNameValuePair("chapter_level", param.get("chapter_level")));
        getRequestParms.add(new BasicNameValuePair("class_ids", param.get("class_ids")));
        getRequestParms.add(new BasicNameValuePair("end_time", param.get("end_time")));
        getRequestParms.add(new BasicNameValuePair("collection_id", param.get("collection_id")));
        getRequestParms.add(new BasicNameValuePair("type_publish", param.get("type_publish")));
        getRequestParms.add(new BasicNameValuePair("type_target", param.get("type_target")));
//        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
//        getRequestParms.add(new BasicNameValuePair("topics", param.get("topics")));
        getRequestParms.add(new BasicNameValuePair("system_id", param.get("system_id")));
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
//        for(int i=0;i<=20000;i++){
        getRequest(param);
//        }
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
