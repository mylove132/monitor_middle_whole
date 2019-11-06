package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.coursepackage;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import okjiaoyu.qa.tools.RandomString;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//新增编辑课程包
public class Api1_3 extends TeacherSpace {
    RandomString randomString = new RandomString();

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
        getRequestParms.add(new BasicNameValuePair("custom_system_id", param.get("custom_system_id")));
        getRequestParms.add(new BasicNameValuePair("share_type", param.get("share_type")));
        getRequestParms.add(new BasicNameValuePair("resource_ids", param.get("resource_ids")));
        getRequestParms.add(new BasicNameValuePair("title", randomString.getRandomString(10)));
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
