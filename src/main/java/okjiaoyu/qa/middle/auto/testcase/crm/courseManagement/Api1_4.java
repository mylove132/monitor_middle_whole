package okjiaoyu.qa.middle.auto.testcase.crm.courseManagement;

import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 课程管理-老师是否已经排课
 * Created by zhangchenglin on 2018/8/28.
 */
public class Api1_4 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("end_time", param.get("end_time")));
        getRequestParams.add(new BasicNameValuePair("start_time", param.get("start_time")));
        getRequestParams.add(new BasicNameValuePair("teacher_id", param.get("teacher_id")));

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
