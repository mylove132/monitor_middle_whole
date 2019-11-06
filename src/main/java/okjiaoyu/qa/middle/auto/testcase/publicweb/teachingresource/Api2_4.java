package okjiaoyu.qa.middle.auto.testcase.publicweb.teachingresource;

import okjiaoyu.qa.middle.auto.testcase.publicweb.PublicWeb;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 资源列表--根据版本ID获取年级列表
 * Created by zhangchenglin on 2018/8/28.
 */

public class Api2_4 extends PublicWeb {

@Override
public void getParams(Map<String, String> param) {
        List<NameValuePair> getRequestParms = new ArrayList<>();
        //parms
        getRequestParms.add(new BasicNameValuePair("version_id", param.get("version_id")));
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