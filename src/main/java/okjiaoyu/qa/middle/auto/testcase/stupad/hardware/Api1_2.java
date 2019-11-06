package okjiaoyu.qa.middle.auto.testcase.stupad.hardware;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by zhudong on 2018/10/12.
 *
 * 2.1魔镜知识点列表接口
 */
public class Api1_2 extends Pad {

    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        getTokenValue(param.get("token"), json);
        json.put("pagesize", param.get("pagesize"));
        json.put("currentpage", param.get("currentpage"));
        json.put("startposition", param.get("startposition"));
        json.put("learnLevel", param.get("learnLevel"));
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
