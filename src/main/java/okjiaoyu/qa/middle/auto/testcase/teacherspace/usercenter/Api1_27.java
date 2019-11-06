package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//获取班级学生列表
public class Api1_27 extends TeacherSpace {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("class_type", param.get("class_type")));
        getRequestParms.add(new BasicNameValuePair("filter_empty_class", param.get("filter_empty_class")));
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
