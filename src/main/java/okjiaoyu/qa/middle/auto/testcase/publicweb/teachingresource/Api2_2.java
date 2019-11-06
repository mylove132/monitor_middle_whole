package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingresource;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 资源库_根据体系类型选择获取对应的目录结构
 */

public class Api2_2 extends PublicWeb {

@Override
public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("region_list_group_id", param.get("region_list_group_id")));
        getRequestParms.add(new BasicNameValuePair("stage_id", param.get("stage_id")));
        getRequestParms.add(new BasicNameValuePair("subject_id", param.get("subject_id")));
        getRequestParms.add(new BasicNameValuePair("topic", param.get("topic")));
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
        }