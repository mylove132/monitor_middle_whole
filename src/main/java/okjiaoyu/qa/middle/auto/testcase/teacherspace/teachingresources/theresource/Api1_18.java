package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/17. 微课库列表
 */
public class Api1_18 extends TeacherSpace {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
        getRequestParms.add(new BasicNameValuePair("res_type", param.get("res_type")));
        getRequestParms.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParms.add(new BasicNameValuePair("sort_type", param.get("sort_type")));
        getRequestParms.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParms.add(new BasicNameValuePair("sort_type", param.get("sort_type")));
        getRequestParms.add(new BasicNameValuePair("origin", param.get("origin")));

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