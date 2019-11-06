package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//手机号替绑

public class Api1_12 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("phone_num", param.get("phone_num")));
        getRequestParms.add(new BasicNameValuePair("verify_code", param.get("verify_code")));
        getRequestParms.add(new BasicNameValuePair("trace_no", param.get("trace_no")));
        getRequestParms.add(new BasicNameValuePair("old_trace_no", param.get("old_trace_no")));
        getRequestParms.add(new BasicNameValuePair("authorize_code", param.get("authorize_code")));
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
