package okjiaoyu.qa.middle.auto.testcase.parentApp.parent.jzgxt;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * shenbingbing add
 * 知识点列表
 */

public class Api1_2 extends ParentApp_parent {
    @Override
    public String getRequestJsonString(Map<String, String> param) {
        JSONObject json = new JSONObject();
        json.put( "area_id",param.get("area_id"));
        json.put( "class_id",param.get("class_id"));
        json.put( "page",param.get("page"));
        json.put( "pagesize",param.get("pagesize"));
        json.put( "point_sign",param.get("point_sign"));
        json.put( "subject_id",param.get("subject_id"));
        json.put( "token",account_token);
        json.put( "uid",account_uid);
        return json.toJSONString();
    }

    @Test(dataProvider = "providerMethod", groups = {"normal"})
    public void test(Map<String, String> param) {
        postRequestByJson(param);
    }


    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        postRequestByJson(param);
    }

}