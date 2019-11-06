package okjiaoyu.qa.middle.auto.testcase.crm.schoolManagement;



import net.sf.json.JSONObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import okjiaoyu.qa.middle.auto.testcase.crm.Crm;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.Args;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学校管理-获取主管方接口
 * Created by zhangchenglin on 2018/8/28.
 */
public class Api1_1 extends Crm {

    @Override
    public void getParams(Map<String, String> param) {

        List<NameValuePair> getRequestParams = new ArrayList<>();
        Map entity = new HashMap();
        //parms
        getRequestParams.add(new BasicNameValuePair("id", param.get("id")));
        getRequestParams.add(new BasicNameValuePair("org_type", param.get("org_type")));
//        entity.put("id", param.get("id"));
//        entity.put("id", param.get("id"));
//        JSONObject jsonObject = JSONObject.fromObject(entity);
//        System.out.println("输出的结果是：" + jsonObject);
       //3、将json对象转化为json字符串getRequestParams.add(new BasicNameValuePair("entity",));
//        String result = jsonObject.toString();
        requestSampler.setGetRequsetParams(getRequestParams);
//        System.out.println(result);
        System.out.println("requestSampler是"+requestSampler);
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
