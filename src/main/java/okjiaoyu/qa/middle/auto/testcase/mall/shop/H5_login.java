package okjiaoyu.qa.middle.auto.testcase.mall.shop;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mall;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.RunningParameter;
import okjiaoyu.qa.tools.TestReport;
import org.testng.annotations.Test;

/**
 * 每次调用之前先登录
 */
public class H5_login extends Mall {
    @Test
    public void login() {
        //requestInfo
        requestSampler.setType(2);//更新cookies，不属于测试用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName("获取cookies给其他接口使用");
        requestSampler.setExpectedCode("status:30200");
        //form-data
        requestSampler.getFormValuePairs().put("phone", phone);
        requestSampler.getFormValuePairs().put("password", password);
        //记录请求信息
        requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getFormValuePairs()));
        APIHttpClient httpClient = new APIHttpClient();
        try {
            //发送请求 & 记录响应信息
            httpClient.postFormdata(requestSampler);
            //共享cookies给其他接口使用
            logger.debug("------- login end --------");
            //判断是否通过
            JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
            RunningParameter.mall_token = responseJson.getString("mall_token");
            logger.info("商城mall登陆获取到的token为: " + RunningParameter.mall_token);
            boolean isPass = isTestCasePass(responseJson, requestSampler.getExpectedCode());
            if (!isPass) {
                TestReport.isPass = false;
                shutDown();
            }
        } catch (Exception e) {
            e.printStackTrace();
            TestReport.isPass = false;
            shutDown();
        }
    }

}
