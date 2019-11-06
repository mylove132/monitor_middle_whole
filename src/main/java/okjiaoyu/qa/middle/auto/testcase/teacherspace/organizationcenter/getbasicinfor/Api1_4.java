package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.getbasicinfor;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/15.  查看知识点结构
 */
public class Api1_4 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
//        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    // @Test(dataProvider = "providerMethod", groups = { "exception" })
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }


}
