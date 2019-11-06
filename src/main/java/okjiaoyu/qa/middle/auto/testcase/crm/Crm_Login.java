package okjiaoyu.qa.middle.auto.testcase.crm;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.RunningParameter;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * crm后台的登录
 */
public class Crm_Login extends Crm {

    public void login() {
        requestSampler.setType(0);//更新cookies，不属于测试用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.getFormValuePairs().put("name", uid);
        requestSampler.getFormValuePairs().put("password", pwd);
//        requestSampler.getFormValuePairs().put("captcha","performance");
        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
        APIHttpClient apiHttpClient = new APIHttpClient();
        apiHttpClient.setCookies();
        apiHttpClient.postFormdata(requestSampler);
    }
}
