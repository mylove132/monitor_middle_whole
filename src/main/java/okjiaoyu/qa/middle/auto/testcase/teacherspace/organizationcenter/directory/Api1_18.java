package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.directory;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Api1_18 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("system_id", param.get("system_id")));
        getRequestParms.add(new BasicNameValuePair("material_id", param.get("material_id")));
        getRequestParms.add(new BasicNameValuePair("version_id", param.get("version_id")));
        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
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