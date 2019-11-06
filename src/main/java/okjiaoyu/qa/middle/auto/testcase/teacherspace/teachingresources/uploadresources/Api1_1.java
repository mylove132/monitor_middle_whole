package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.uploadresources;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by leo on 17/5/25.
 */
public class Api1_1 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("file_name", param.get("file_name"));
        requestSampler.getFormValuePairs().put("md5", param.get("md5"));
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
