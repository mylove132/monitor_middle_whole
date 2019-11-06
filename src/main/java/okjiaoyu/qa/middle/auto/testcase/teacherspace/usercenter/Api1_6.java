package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//获取图形验证码
public class Api1_6 extends TeacherSpace {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    //    @Test(dataProvider = "providerMethod", groups = { "normal" })
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    //    @Test(dataProvider = "providerMethod", groups = { "exception" })
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }


}
