package okjiaoyu.qa.middle.auto.testcase.stupad.launcher;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong on 2018/6/22.
 * for interface 2.1 apiRequest
 * 1.14 获取主屏推荐的任务列表(智慧学习4.0新增)
 */
public class Api1_14 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
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
