package okjiaoyu.qa.middle.auto.testcase.teacherspace.dataapplication;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 17/1/15. 设置未达标
 */
public class Api1_5 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("class_id", param.get("class_id")));
        getRequestParms.add(new BasicNameValuePair("level", param.get("level")));
        getRequestParms.add(new BasicNameValuePair("value", param.get("value")));
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