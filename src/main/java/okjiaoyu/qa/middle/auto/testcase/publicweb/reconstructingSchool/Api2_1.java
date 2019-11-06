package okjiaoyu.qa.middle.auto.testcase.publicweb.reconstructingSchool;


import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 教师管理-列表接口
 * Created by zhangchenglin on 2018/10/8.
 */
public class Api2_1 extends PublicWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("authority", param.get("authority")));
        getRequestParms.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParms.add(new BasicNameValuePair("status", param.get("status")));
        getRequestParms.add(new BasicNameValuePair("subject", param.get("subject")));
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