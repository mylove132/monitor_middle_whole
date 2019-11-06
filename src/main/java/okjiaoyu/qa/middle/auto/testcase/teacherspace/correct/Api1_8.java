package okjiaoyu.qa.middle.auto.testcase.teacherspace.correct;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 17/1/15. 批改结果提交
 */
public class Api1_8 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("publish_id", param.get("publish_id")));
        getRequestParms.add(new BasicNameValuePair("link_id", param.get("link_id")));
        getRequestParms.add(new BasicNameValuePair("resource_id", param.get("resource_id")));
        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParms.add(new BasicNameValuePair("question_id", param.get("question_id")));
        getRequestParms.add(new BasicNameValuePair("student_id", param.get("student_id")));
        getRequestParms.add(new BasicNameValuePair("answer", param.get("answer")));
        getRequestParms.add(new BasicNameValuePair("struct_id", param.get("struct_id")));
        getRequestParms.add(new BasicNameValuePair("resource_id", param.get("resource_id")));
        getRequestParms.add(new BasicNameValuePair("link_id", param.get("link_id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
