package okjiaoyu.qa.middle.auto.testcase.platformresource;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.TestReport;
import org.testng.annotations.Test;


/**
 * 每次调用之前先登录
 */
public class Pr_login extends PlatformResource {


    @Test
    public void login() {
        //requestInfo
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("uid", uid);
        jsonObject.put("pwd", pwd);
        String response = new APIHttpClient().executePostRequest(getInterfaceUrl(), jsonObject, "07");
        JSONObject responseJson = JSONObject.parseObject(response);
        System.out.println("登陆的response:" + responseJson.toJSONString());
    }

}
