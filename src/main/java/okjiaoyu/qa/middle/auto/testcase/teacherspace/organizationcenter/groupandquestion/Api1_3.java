package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.groupandquestion;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/15. 题目新增
 */
public class Api1_3 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("source", param.get("source")));
        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParms.add(new BasicNameValuePair("html", param.get("html")));
        getRequestParms.add(new BasicNameValuePair("groupId", param.get("groupId")));
        getRequestParms.add(new BasicNameValuePair("topic", param.get("topic")));
        getRequestParms.add(new BasicNameValuePair("chapter", param.get("chapter")));
        getRequestParms.add(new BasicNameValuePair("ref", param.get("ref")));
        getRequestParms.add(new BasicNameValuePair("level", param.get("level")));
        getRequestParms.add(new BasicNameValuePair("status", param.get("status")));
        getRequestParms.add(new BasicNameValuePair("id", param.get("id")));
        getRequestParms.add(new BasicNameValuePair("versionId", param.get("versionId")));
        getRequestParms.add(new BasicNameValuePair("directoryId", param.get("directoryId")));
        getRequestParms.add(new BasicNameValuePair("customDirectoryId", param.get("customDirectoryId")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        for (int i = 0; i <= 20; i++) {
            getRequest(param);
        }
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
