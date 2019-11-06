package okjiaoyu.qa.middle.auto.testcase.teacherspace.ksu;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 17/11/7.
 */
public class Api1_5 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        getRequestParms.add(new BasicNameValuePair("order_ids", param.get("order_ids")));
        getRequestParms.add(new BasicNameValuePair("start_time", param.get("start_time")));
        getRequestParms.add(new BasicNameValuePair("end_time", param.get("end_time")));
        getRequestParms.add(new BasicNameValuePair("goods_id", param.get("goods_id")));

        getRequestParms.add(new BasicNameValuePair("resource_ids", param.get("resource_ids")));
        getRequestParms.add(new BasicNameValuePair("type_publish", param.get("type_publish")));
        getRequestParms.add(new BasicNameValuePair("course_name", param.get("course_name")));
        getRequestParms.add(new BasicNameValuePair("custom_system_id", param.get("custom_system_id")));
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
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