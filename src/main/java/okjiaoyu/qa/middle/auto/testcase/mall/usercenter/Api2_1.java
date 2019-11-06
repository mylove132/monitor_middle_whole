package okjiaoyu.qa.middle.auto.testcase.mall.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.tools.TestReport;
import okjiaoyu.qa.tools.handler.JsonpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 删除地址
 * Created by leo on 17/7/4.
 */
public class Api2_1 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
        getRequestParms.add(new BasicNameValuePair("id", param.get("id")));
        getRequestParms.add(new BasicNameValuePair("m", param.get("m")));

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
