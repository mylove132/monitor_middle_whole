package okjiaoyu.qa.middle.auto.testcase.privateweb.tradeManagement;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 配置班级-班级列表
 * Created by zhangchenglin on 2018/5/17.
 */
public class Api1_13 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("grade_id", param.get("grade_id")));
        getRequestParams.add(new BasicNameValuePair("teacher_id", param.get("teacher_id")));
        getRequestParams.add(new BasicNameValuePair("eniminate", param.get("eniminate")));
        getRequestParams.add(new BasicNameValuePair("keyword", param.get("keyword")));
        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParams.add(new BasicNameValuePair("student_id", param.get("student_id")));


        requestSampler.setGetRequsetParams(getRequestParams);
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
