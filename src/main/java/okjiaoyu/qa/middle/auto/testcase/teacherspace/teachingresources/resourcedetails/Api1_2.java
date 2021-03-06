package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.resourcedetails;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//共享我的资源
public class Api1_2 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParms.add(new BasicNameValuePair("rid", param.get("rid")));
        getRequestParms.add(new BasicNameValuePair("share_type", param.get("share_type")));
        getRequestParms.add(new BasicNameValuePair("is_wenku", param.get("is_wenku")));
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
