package okjiaoyu.qa.tools.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zhangxiaozheng on 2016/7/21
 */
public class JsonpHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    public JSONObject parseJsonP(String jsonpString) {
        String jsonString = getJsonString(jsonpString);
        return JSONObject.parseObject(jsonString);
    }

    public String getJsonString(String jsonp_str) {
        int index = jsonp_str.indexOf("(");
        int lastindex = jsonp_str.lastIndexOf(")");
        String json_str = jsonp_str.substring(index + 1, lastindex);
        return json_str;
    }


    @Test
    public void test() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "zhang");
        jsonObject.put("age", 19);
        String jsonpString = "function(" + jsonObject.toJSONString() + ")";
        logger.info("jsonpString:" + jsonpString);
        String jsonString = getJsonString(jsonpString);
        logger.info("jsonString:" + jsonString);
        JSONObject json = JSONObject.parseObject(jsonString);
        logger.info(json.toJSONString());

    }


}
