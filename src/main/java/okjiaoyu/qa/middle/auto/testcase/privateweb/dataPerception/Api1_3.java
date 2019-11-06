package okjiaoyu.qa.middle.auto.testcase.privateweb.dataPerception;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据感知-查看所有年级
 * Created by zhangchenglin on 2018/11/13
 */
public class Api1_3 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
//        getRequestParams.add(new BasicNameValuePair("type", param.get("type")));

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
