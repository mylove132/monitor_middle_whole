package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by leo on 16/1/17.  获取资源
 */
public class Api1_3 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("id", param.get("id"));
        requestSampler.getFormValuePairs().put("type", param.get("type"));
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    //@Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
