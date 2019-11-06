package okjiaoyu.qa.middle.auto.testcase.privateweb.mergeOfPublicAndPrivate;

import okjiaoyu.qa.middle.auto.testcase.privateweb.PrivateWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 公私立校后台合并---获取班级学生列表
 * Created by zhangchenglin on 2018/9/16
 */
public class Api1_12 extends PrivateWeb {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("page", param.get("page")));
        getRequestParams.add(new BasicNameValuePair("page_size", param.get("page_size")));
        getRequestParams.add(new BasicNameValuePair("class_id", param.get("class_id")));
        getRequestParams.add(new BasicNameValuePair("grade_id", param.get("grade_id")));
        getRequestParams.add(new BasicNameValuePair("stage_id", param.get("stage_id")));
        getRequestParams.add(new BasicNameValuePair("is_history", param.get("is_history")));
        getRequestParams.add(new BasicNameValuePair("class_status", param.get("class_status")));
        getRequestParams.add(new BasicNameValuePair("history_id", param.get("history_id")));

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
