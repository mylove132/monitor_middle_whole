package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingquality;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 答题场景分布
 * Created by chaozhe on 2018/2/23.
 */
public class Api3_1 extends PublicWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("code", param.get("code")));
        getRequestParams.add(new BasicNameValuePair("end", param.get("end")));
        getRequestParams.add(new BasicNameValuePair("is_pad", param.get("is_pad")));
        getRequestParams.add(new BasicNameValuePair("org_type", param.get("org_type")));
        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParams.add(new BasicNameValuePair("stage", param.get("stage")));
        getRequestParams.add(new BasicNameValuePair("start", param.get("start")));
        getRequestParams.add(new BasicNameValuePair("subject", param.get("subject")));
        getRequestParams.add(new BasicNameValuePair("type", param.get("type")));
        getRequestParams.add(new BasicNameValuePair("user_code", param.get("user_code")));
        getRequestParams.add(new BasicNameValuePair("user_type", param.get("user_type")));
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
