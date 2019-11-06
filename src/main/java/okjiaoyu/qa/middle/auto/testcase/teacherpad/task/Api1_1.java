package okjiaoyu.qa.middle.auto.testcase.teacherpad.task;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.teacherpad.TeacherPad;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取当前任务资源列表--先执行，可以获取link_id
 * <p>
 * Created by chaozhe on 2017/6/12.
 */
public class Api1_1 extends TeacherPad {

    String token = "";

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        token = param.get("token");
        JSONObject jsonObject = new JSONObject();
        getLoginUid(param.get("uid"), jsonObject);
        getLoginToken(param.get("token"), jsonObject);
        jsonObject.put("link_id", param.get("link_id"));
        jsonObject.put("resource_id", param.get("resource_id"));
        jsonObject.put("scene_type", param.get("scene_type"));
        jsonObject.put("student_id", param.get("student_id"));
        return jsonObject.toJSONString();
//        return token;
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestTest(param);
//        postRequesttest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestTest(param);
    }


}
