package okjiaoyu.qa.middle.auto.testcase.publicweb.classportal;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询班级老师分学科查询
 */

public class Api2_6 extends PublicWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("grade", param.get("grade")));
        getRequestParms.add(new BasicNameValuePair("pad_class", param.get("pad_class")));
        getRequestParms.add(new BasicNameValuePair("week_time", param.get("week_time")));
        getRequestParms.add(new BasicNameValuePair("year", param.get("year")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }


}