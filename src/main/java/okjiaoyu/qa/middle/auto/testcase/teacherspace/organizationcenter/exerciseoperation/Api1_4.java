package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.exerciseoperation;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/17. 修改保存题集
 */
public class Api1_4 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("title", param.get("title")));
        getRequestParms.add(new BasicNameValuePair("custom_system_id", param.get("custom_system_id")));
        getRequestParms.add(new BasicNameValuePair("question_ids", param.get("question_ids")));
        getRequestParms.add(new BasicNameValuePair("sort_type", param.get("sort_type")));
        getRequestParms.add(new BasicNameValuePair("custom_directory_id", param.get("custom_directory_id")));
        getRequestParms.add(new BasicNameValuePair("collection_id", param.get("collection_id")));
        getRequestParms.add(new BasicNameValuePair("directory_id", param.get("directory_id")));
        getRequestParms.add(new BasicNameValuePair("topics", param.get("topics")));
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
