package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.questionreport;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/15. 根据发布的作业，查看某个学生的习题报告
 */
public class Api1_4 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("history_id", param.get("history_id")));
        getRequestParms.add(new BasicNameValuePair("student_id", param.get("student_id")));
        getRequestParms.add(new BasicNameValuePair("type_scene", param.get("type_scene")));
        getRequestParms.add(new BasicNameValuePair("resource_id", param.get("resource_id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }


}
