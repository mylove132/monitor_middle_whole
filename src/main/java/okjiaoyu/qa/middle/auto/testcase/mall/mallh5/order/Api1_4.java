package okjiaoyu.qa.middle.auto.testcase.mall.mallh5.order;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.middle.auto.testcase.mall.Mallh5_parent;
import okjiaoyu.qa.tools.RunningParameter;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取支付方式-app---get请求
 * Created by shenbingbing 2019/01/25
 */
public class Api1_4 extends Mallh5_parent {
    @Test(dataProvider = "providerMethod", groups = {"normal"})
        public void test(Map<String, String> param) {
        getRequest(param);
    }

    @Test(dataProvider = "providerMethod", groups = {"exception"})
    public void exceptionTest(Map<String, String> param) {
        getRequest(param);
    }

}
