package okjiaoyu.qa.middle.auto.testcase.crm.areaManagement;

import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 区域管理--获取省市区
 * Created by zhangchenglin on 2018/8/28.
 */
public class Api1_3 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parm
        getRequestParams.add(new BasicNameValuePair("level", param.get("level")));
        getRequestParams.add(new BasicNameValuePair("code", param.get("code")));
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
