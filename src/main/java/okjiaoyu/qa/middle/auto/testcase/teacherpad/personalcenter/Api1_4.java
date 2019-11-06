/*
package okjiaoyu.qa.middle.auto.testcase.teacherpad.personalcenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.testng.annotations.Test;

import java.util.Map;

*/
/**
 * 注销
 * Created by chaozhe on 2017/6/13.
 *//*

public class Api1_4 extends TeacherPad{
    @Override
     public String getRequestJsonString(Map<String, String> param) {
         JSONObject jsonObject = new JSONObject();
         getLoginToken(param.get("token"),jsonObject);
         getLoginUid(param.get("uid"),jsonObject);
         return jsonObject.toJSONString();
     }
    @Test(dataProvider = "providerMethod", groups = { "normal" })
    public void test(Map<String, String> param){
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = { "exception" })
    public void exceptionTest(Map<String, String> param){
        postRequest(param);
    }
}
*/
