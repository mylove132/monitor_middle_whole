package okjiaoyu.qa.middle.auto.testcase.teacherspace.ksu;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Api1_8 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        getRequestParms.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParms.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParms.add(new BasicNameValuePair("order_id", param.get("order_id")));
        getRequestParms.add(new BasicNameValuePair("student_id", param.get("student_id")));
        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));

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