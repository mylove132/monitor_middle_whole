package okjiaoyu.qa.middle.auto.testcase.stupad.launcher;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.stupad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by shenzhenhua on 2018/7/26.
 * for interface 2.1 apiRequest
 * 1.7 自主学习推荐列表（废弃掉，暂时不用）
 */
//public class Api1_7 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        getTokenValue(param.get("token"), json);
//        json.put("currentpage",param.get("currentpage"));
//        json.put("pagesize",param.get("pagesize"));
//        return json.toJSONString();
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequest(param);
//    }
//
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postRequest(param);
//    }
//
//
//
//
//
//}
