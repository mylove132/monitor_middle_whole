package okjiaoyu.qa.middle.auto.testcase.crm.teachingMaterialManagement;


import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 教材版本管理--教材版本列表
 * Created by zhangchenglin on 2019/01/07.
 */
public class Api1_11 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {

        List<NameValuePair> getRequestParams = new ArrayList<>();
        Map entity = new HashMap();
        //parms
        getRequestParams.add(new BasicNameValuePair("subjectId", param.get("subjectId")));
        getRequestParams.add(new BasicNameValuePair("stageId", param.get("stageId")));
        requestSampler.setGetRequsetParams(getRequestParams);
//        System.out.println("requestSampler是" + requestSampler);
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
