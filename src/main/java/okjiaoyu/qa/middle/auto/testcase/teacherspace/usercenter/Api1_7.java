package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;

//验证手机号
public class Api1_7 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("verify_code", param.get("verify_code"));
        requestSampler.getFormValuePairs().put("phone_num", param.get("phone_num"));
        System.out.println("上行的内容是: " + requestSampler.getFormValuePairs());
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
