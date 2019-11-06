package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.exerciseoperation;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import okjiaoyu.qa.tools.RandomString;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by leo on 16/1/17. 保存题集 ，监控异常
 */
public class Api1_1 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        RandomString randomString = new RandomString();
        getRequestParms.add(new BasicNameValuePair("title", randomString.getRandomString(10)));
//        getRequestParms.add(new BasicNameValuePair("chapter_id", param.get("chapter_id")));
        getRequestParms.add(new BasicNameValuePair("question_ids", param.get("question_ids")));
//        getRequestParms.add(new BasicNameValuePair("chapter_level", param.get("chapter_level")));
        getRequestParms.add(new BasicNameValuePair("sort_type", param.get("sort_type")));
        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
        getRequestParms.add(new BasicNameValuePair("share_type", param.get("share_type")));
        getRequestParms.add(new BasicNameValuePair("topics", param.get("topics")));
        getRequestParms.add(new BasicNameValuePair("custom_system_id", param.get("custom_system_id")));
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
//        int i;
//        for(i=0;i<1000;i++){
//            getRequest(param);}
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
