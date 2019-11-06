package okjiaoyu.qa.middle.auto.testcase.stupad.launcher;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong on 2018/6/22.
 * for interface 2.1 apiRequest
 * 1.13 主屏推荐内容列表(智慧学习4.0新增)
 */
public class Api1_13 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("kid", Integer.parseInt(param.get("kid")));
        json.put("ktype", Integer.parseInt(param.get("ktype")));
        json.put("refresh", Integer.parseInt(param.get("refresh")));
        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
        return json.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequest(param);
    }

}
