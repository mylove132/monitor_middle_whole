package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingresource;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自建体系_目录结构_获取父级下的子级集合
 */

public class Api1_5 extends PublicWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("id", param.get("id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

//    @Test(dataProvider = "providerMethod", groups = {"normal"})
//    public void test(Map<String, String> param) {
//        getRequest(param);
//    }


    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }
}