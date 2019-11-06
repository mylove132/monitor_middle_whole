package okjiaoyu.qa.middle.auto.testcase.privateweb.mergeOfPublicAndPrivate;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 公私立校后台合并---获取操作记录--审核记录
 * Created by zhangchenglin on 2018/9/16
 */
public class Api1_6 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("apply_type", param.get("apply_type")));
        getRequestParams.add(new BasicNameValuePair("review_result", param.get("review_result")));
        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParams.add(new BasicNameValuePair("review_time_end", param.get("review_time_end")));
        getRequestParams.add(new BasicNameValuePair("review_time_start", param.get("review_time_start")));
        requestSampler.setGetRequsetParams(getRequestParams);
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
