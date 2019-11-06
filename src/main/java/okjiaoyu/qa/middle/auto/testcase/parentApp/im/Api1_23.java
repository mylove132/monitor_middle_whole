package okjiaoyu.qa.middle.auto.testcase.parentApp.im;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * shenbingbing add 2019/02/19
 * 根据学生或家长信息获取相关老师和机构通讯录
 */
public class Api1_23 extends ParentApp_parent {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        getRequestParams.add(new BasicNameValuePair("scene", param.get("scene")));
        getRequestParams.add(new BasicNameValuePair("uid", account_uid));
        requestSampler.setGetRequsetParams(getRequestParams);
    }
    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        getRequestUtil(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequestUtil(param);
    }

}