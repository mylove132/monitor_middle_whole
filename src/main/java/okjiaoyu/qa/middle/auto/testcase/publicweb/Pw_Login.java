package okjiaoyu.qa.middle.auto.testcase.publicweb;

import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.singleLogin.SingleLogin;
import org.apache.http.client.CookieStore;


/**
 * 每次调用之前先登录
 */
public class Pw_Login extends PublicWeb {


    public void login() {
//        requestSampler.setType(0);//更新cookies，不属于测试用例
//        requestSampler.setRequestUrl(getInterfaceUrl());
//        requestSampler.getFormValuePairs().put("account", uid);
//        requestSampler.getFormValuePairs().put("password", pwd);
//        requestSampler.getFormValuePairs().put("captcha", "performance");
//        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
//        APIHttpClient apiHttpClient = new APIHttpClient();
//        apiHttpClient.setCookies();
//
//        apiHttpClient.postFormdata(requestSampler);

        String url = RunningParameter.urlHeader;
        String header = url.substring(0, url.length() - 1);
        CookieStore cookieStore = new SingleLogin(header, uid, pwd).login().getCookieStore();
        requestSampler.setCookieStore(cookieStore);
        RunningParameter.cookieStore = cookieStore;

        boolean isPass = !cookieStore.toString().isEmpty();

        if (isPass) {
            requestSampler.setPass(true);
            logger.info("公立后台登录成功");
        } else {
            requestSampler.setPass(false);
            logger.info("公立后台登录失败");
        }


    }

}
