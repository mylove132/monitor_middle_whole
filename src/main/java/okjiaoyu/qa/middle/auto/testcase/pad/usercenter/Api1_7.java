package okjiaoyu.qa.middle.auto.testcase.pad.usercenter;

import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import okjiaoyu.qa.tools.APIHttpClient;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.2 图片上传
 */
public class Api1_7 extends Pad {


    @Test(dataProvider = "providerMethod")
    public void test(Map<String, String> param) {
        postRequest(param);
    }

    @Test
    public void uploadPic() {
        //requestInfo
        requestSampler.setType(0);//正常用例
        requestSampler.setRequestUrl(getInterfaceUrl());
        requestSampler.setInterfaceName(getInterfaceName());
        requestSampler.setTestCaseName(getInterfaceName() + " - 成功上传图片");
        requestSampler.setExpectedCode("0");
        //form-data
        requestSampler.getFormValuePairs().put("uid", Pad.account_uid);
        requestSampler.getFormValuePairs().put("token", Pad.account_token);
        requestSampler.getFormFiles().put("avatar", Pad.pics[0]);
        //发送请求
        APIHttpClient httpClient = new APIHttpClient();
        logger.info("[requestUrl]:" + requestSampler.getRequestUrl());
        httpClient.postFormdata(requestSampler);
        //断言，打印结果
        isSuccess(requestSampler);
    }


}
