package okjiaoyu.qa.middle.auto.testcase.mall.usercenter;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.tools.TestReport;
import okjiaoyu.qa.tools.handler.JsonpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 17/7/4.
 */
public class Api1_6 extends Mall {
    @Override
    public void getParams(Map<String, String> param) {
        //params for Get request
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("c", param.get("c")));
        getRequestParms.add(new BasicNameValuePair("a", param.get("a")));
        getRequestParms.add(new BasicNameValuePair("verifyTel", param.get("verifyTel")));
        getRequestParms.add(new BasicNameValuePair("verifyCode", param.get("verifyCode")));

        requestSampler.setGetRequsetParams(getRequestParms);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

    public void isSuccess(RequestSampler requestSampler) {
        //判断测试用例是否通过
        if (requestSampler.getHttpStatus() == 200) {
            String response = requestSampler.getResponseInfo();
            JsonpHandler jsonpHandler = new JsonpHandler();
            JSONObject responseJson = JSONObject.parseObject(jsonpHandler.getJsonString(response));
            System.out.print("jsonp转为json: " + responseJson);
            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
            requestSampler.setPass(isPass);
            if (isPass) {
                logger.info(requestSampler.getResultInfo());
            } else {
                TestReport.isPass = false;
                requestSampler.printRequestErrorDetail();//将请求的所有详情，打印到错误日志中
            }
        } else {//http请求失败
            TestReport.isPass = false;
            requestSampler.setPass(false);
        }
        Assert.assertEquals(requestSampler.getHttpStatus(), 200, "http请求的状态码不是200，http请求失败");
        Assert.assertTrue(requestSampler.isPass());
    }

}
