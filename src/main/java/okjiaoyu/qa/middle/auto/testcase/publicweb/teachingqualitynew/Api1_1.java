package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingqualitynew;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 教师资源贡献统计-总体数据情况
 * Created by chaozhe on 2018/2/8.
 */
public class Api1_1 extends PublicWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("begin_time", param.get("begin_time")));
        getRequestParams.add(new BasicNameValuePair("end_time", param.get("end_time")));
        getRequestParams.add(new BasicNameValuePair("stage", param.get("stage")));
        getRequestParams.add(new BasicNameValuePair("grade", param.get("grade")));
        getRequestParams.add(new BasicNameValuePair("subject", param.get("subject")));
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
