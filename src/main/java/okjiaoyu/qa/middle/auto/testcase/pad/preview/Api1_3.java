package okjiaoyu.qa.middle.auto.testcase.pad.preview;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.pad.Pad;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by 晓 on 2015/7/9.
 * for interface 2.1 apiRequest
 * 1.3 预习资源列表协议
 */
public class Api1_3 extends Pad {
//
//    @Override
//    public String getRequestJsonString(Map<String, String> param){
//        JSONObject json = new JSONObject();
//        getUidValue(param.get("uid"), json);
//        getTokenValue(param.get("token"), json);
//        json.put("kpoint", param.get("kpoint"));
//        json.put("type", Integer.parseInt(param.get("type")));
//        json.put("currentpage", Integer.parseInt(param.get("currentpage")));
//        json.put("pagesize", Integer.parseInt(param.get("pagesize")));
//        return json.toJSONString();
//    }

//    @Override
//    public void dataTest(RequestSampler requestSampler) {
//        JSONObject requestJson = JSONObject.parseObject(requestSampler.getRequestInfo());
//        JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
//        //题集id
//        String kpoint = requestJson.get("kpoint").toString();
//        JSONArray array = responseJson.getJSONObject("data").getJSONArray("reslist");
//        int size = array.size();
//        if(size > 0){
//            requestSampler.setDataCheck(true);
//            requestSampler.setDataCheckDetail("获取预习题集kpoint=" + kpoint + "共 " + size + "个教学资源");
//        }else{
//            requestSampler.setDataCheck(false);
//            requestSampler.setDataCheckDetail("获取预习题集kpoint=" + kpoint + "教学资源列表失败");
//        }
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "normal" })
//    public void test(Map<String, String> param){
//        postRequest(param);
//    }
//
//    @Test(dataProvider = "providerMethod", groups = { "exception" })
//    public void exceptionTest(Map<String, String> param){
//        postRequest(param);
//    }

}
