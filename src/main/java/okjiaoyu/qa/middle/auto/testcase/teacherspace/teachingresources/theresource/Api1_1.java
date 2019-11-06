package okjiaoyu.qa.middle.auto.testcase.teacherspace.teachingresources.theresource;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by leo on 16/1/17.  创建资源
 */
public class Api1_1 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("fileName", param.get("fileName"));
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
//                for(int i=0;i<=1000;i++) {
        postFormRequest(param);
//                }
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
