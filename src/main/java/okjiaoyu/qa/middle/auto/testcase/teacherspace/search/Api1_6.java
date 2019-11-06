package okjiaoyu.qa.middle.auto.testcase.teacherspace.search;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 17/1/15. 导航栏中 获取单题的数量
 */
public class Api1_6 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("subject_id", param.get("subject_id")));
        getRequestParms.add(new BasicNameValuePair("org_id", param.get("org_id")));
        getRequestParms.add(new BasicNameValuePair("org_type", param.get("org_type")));
        getRequestParms.add(new BasicNameValuePair("query_type", param.get("query_type")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    //@Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    //@Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
