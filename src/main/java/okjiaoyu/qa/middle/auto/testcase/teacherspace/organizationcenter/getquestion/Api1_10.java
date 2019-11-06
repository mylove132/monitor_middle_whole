package okjiaoyu.qa.middle.auto.testcase.teacherspace.organizationcenter.getquestion;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 16/1/17.  题纠错
 */
public class Api1_10 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("id", param.get("id"));
        requestSampler.getFormValuePairs().put("code", param.get("code"));
        requestSampler.getFormValuePairs().put("remark", param.get("remark"));
        requestSampler.getFormValuePairs().put("collection_id", param.get("collection_id"));
    }

    //@Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    //@Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
