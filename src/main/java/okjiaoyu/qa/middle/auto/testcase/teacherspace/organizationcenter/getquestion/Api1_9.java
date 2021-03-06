package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.getquestion;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/17.  获取题列表
 */
public class Api1_9 extends TeacherSpace {

//    @Override
//    public void getParams(Map<String, String> param){
//        //params for Get request
//        List<NameValuePair> getRequestParms = new ArrayList<>();
//        getRequestParms.add(new BasicNameValuePair("chapter_id", param.get("chapter_id")));
//        getRequestParms.add(new BasicNameValuePair("chapter_level", param.get("chapter_level")));
//        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
//        getRequestParms.add(new BasicNameValuePair("page", param.get("page")));
//        requestSampler.setGetRequsetParams(getRequestParms);
//    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
