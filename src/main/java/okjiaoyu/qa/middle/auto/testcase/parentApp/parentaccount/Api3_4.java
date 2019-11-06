package okjiaoyu.qa.middle.auto.testcase.parentApp.parentaccount;


import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//根据题集id获取作业详情

public class Api3_4 extends ParentApp_parent {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("history_id", param.get("history_id")));
        getRequestParms.add(new BasicNameValuePair("student_id", param.get("student_id")));
        getRequestParms.add(new BasicNameValuePair("exercise_source", param.get("exercise_source")));
        getRequestParms.add(new BasicNameValuePair("requestid", "10"));
        getRequestParms.add(new BasicNameValuePair("token", account_token));
        getRequestParms.add(new BasicNameValuePair("uid", account_uid));
        requestSampler.setGetRequsetParams(getRequestParms);
        requestSampler.setRequestMethod(param.get("requestMethod"));
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