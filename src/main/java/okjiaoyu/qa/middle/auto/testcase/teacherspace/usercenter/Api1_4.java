package okjiaoyu.qa.middle.auto.testcase.teacherspace.usercenter;

import okjiaoyu.qa.middle.auto.testcase.teacherspace.TeacherSpace;
import org.testng.annotations.Test;

import java.util.Map;
//重置密码-私立

public class Api1_4 extends TeacherSpace {

    @Override
    public void getParams(Map<String, String> param) {
        requestSampler.getFormValuePairs().put("systemId", param.get("systemId"));
        System.out.println("上行的内容是: " + requestSampler.getFormValuePairs());
    }

//    @Override
//    public void dataTest(RequestSampler requestSampler) {
//        JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
//        //科目sid
//        long size = Long.parseLong(responseJson.getJSONObject("success").get("true").toString());
//        if(size > 0){
//            requestSampler.setDataCheck(true);
//            requestSampler.setDataCheckDetail("重置密码公立成功");
//        }else{
//            requestSampler.setDataCheck(false);
//            requestSampler.setDataCheckDetail("重置密码公立成功失败");
//        }
//    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postFormRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postFormRequest(param);
    }

}
