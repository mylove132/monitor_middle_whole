package okjiaoyu.qa.middle.auto.testcase.parentApp.im;/*
package okjiaoyu.qa.middle.auto.testcase.parentApp.im;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * shenbingbing add 2019/02/19
 *  根据联系人ids获取未读消息数_机构后台用   app端不存在此接口
 *//*

public class Api1_15 extends ParentApp_parent {

    @Override
    public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParams = new ArrayList<>();
        //parms
        getRequestParams.add(new BasicNameValuePair("ids", param.get("ids")));
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

}*/
