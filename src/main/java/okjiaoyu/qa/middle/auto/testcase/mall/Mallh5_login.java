package okjiaoyu.qa.middle.auto.testcase.mall;
import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.GetPropertiesData;
import okjiaoyu.qa.tools.TestReport;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
/**
 * shenbingbing add
 * 每次调用之前先登录
 */
public class Mallh5_login extends Mallh5_parent {
    private HttpPost httppost = null;
    private String requestId;
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private int httpStatusCode;
    private HttpGet httpGet = null;
    private HttpClientContext context = new HttpClientContext();
    public JSONObject getReJson() {
        return reJson;
    }
    private JSONObject reJson;
    @Test
    public void login() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("ua", "iphone");
        parameters.put("os", "ios");
        parameters.put("vs", "2.0.0");
        parameters.put("vc", "35");
        parameters.put("sw", "480");
        parameters.put("sh", "800");
        parameters.put("serial", "803330");
        parameters.put("udid", "uqwbejqweqwoeqnwekjasdad");
        parameters.put("channel", "11");
        parameters.put("contype", "1");
        parameters.put("imei", "qwiuenqweqada");
        parameters.put("imsi", "qwiuenqweqada");
        parameters.put("mac", "qwe123123ada231");
        parameters.put("role", "0");
        Map<String, String> map = new HashMap<>();
        map.put("account", account_uname);
        map.put("pwd", account_pwd);
        map.put( "type","1" );
        JSONObject jsonObject = new JSONObject();
        jsonObject.put( "type",map);
        jsonObject.putAll(parameters);
        requestSampler.setRequestInfo(jsonObject.toJSONString());
        logger.info("[requestJson]:" + JSONObject.toJSONString(jsonObject));
        requestSampler.setRequestUrl(getInterfaceUrlLogin());
        requestSampler.setTestCaseName("登陆");
        new APIHttpClient().executePostRequest(requestSampler);
        JSONObject responseJson = JSONObject.parseObject(requestSampler.getResponseInfo());
        logger.info( "登录okay用于商城操作: " + responseJson);
        account_token=responseJson.getJSONObject( "data" ).getJSONObject( "parent" ).get( "token" ).toString();
        logger.info("登录okay用于商城操作返回account-token is: " + account_token);
        account_uid = responseJson.getJSONObject("data").getJSONObject( "parent" ).get("uid").toString();
        logger.info("登录okay用于商城操作返回account-uid is: " + account_uid);
    }
    /**
     * 为了不在公用方法中添加内容，将此类中单独写一份
     * @param requestSampler
     */
    public void executePostRequestH5(RequestSampler requestSampler) {
        logger.info("--------------- executePostRequest start -----------------");
        httppost = new HttpPost(requestSampler.getRequestUrl());
        try {
            requestId = new APIHttpClient().generateRequestId(requestSampler.getRequestProId());
            requestSampler.setRequestId(requestId);
            httppost.addHeader("requestid", requestId);
            httppost.addHeader("vs", "1.0.0.2");
            httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
            //shenbingbing add start 手机端-新商城专用,这个请求头是必须的;
            httppost.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16C50 ;IOS/com.okay.education ;okay_version/(null)");
            //shenbingbing add end
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(JSONObject.parseObject(requestSampler.getRequestInfo())));
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httppost.setEntity(stringEntity);
            HttpResponse response = httpClient.execute(httppost);
            this.httpStatusCode = response.getStatusLine().getStatusCode();
            requestSampler.setHttpStatus(this.httpStatusCode);
            if (httpStatusCode == HttpStatus.SC_OK) {
                String reData = EntityUtils.toString(response.getEntity());
                this.reJson = JSONObject.parseObject(reData);
                requestSampler.setResponseInfo(this.reJson.toString());
            }
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.error("Method failed:" + response.getStatusLine());
            }
        } catch (IOException e) {
            //发生网络异常
            logger.error("Network Exception Occurred!\n" + ExceptionUtils.getFullStackTrace(e));
        }
        logger.info("--------------- executePostRequest  complete -----------------");
    }
    public void getRequestH5(RequestSampler requestSampler) {
        httpGet = new HttpGet(requestSampler.getRequestUrl());
        try {
            requestId = new APIHttpClient().generateRequestId(requestSampler.getRequestProId());
            requestSampler.setRequestId(requestId);
            httpGet.addHeader("requestid", requestId);
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("X-Requested-With", "XMLHttpRequest");
            //shenbingbing add start 手机端-新商城专用,这个请求头是必须的;
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16C50 ;IOS/com.okay.education ;okay_version/(null)");
            //shenbingbing add end
            if ("08".equals(requestSampler.getRequestProId())) {
                GetPropertiesData getPropertiesData = new GetPropertiesData();
                httpGet.addHeader("referer", getPropertiesData.getData("referer"));
            }
            NameValuePair requestidPair = new BasicNameValuePair("requestid", requestSampler.getRequestId());
            requestSampler.getGetRequsetParams().add(requestidPair);
            String str = EntityUtils.toString(new UrlEncodedFormEntity(requestSampler.getGetRequsetParams()));
            httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
            //保存上行参数数据
            requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getGetRequsetParams()));
            HttpResponse response = httpClient.execute(httpGet);
            CookieStore cookieStore = context.getCookieStore();
            this.httpStatusCode = response.getStatusLine().getStatusCode();
            requestSampler.setHttpStatus(this.httpStatusCode);
            //当获得正确响应时
            if (httpStatusCode == HttpStatus.SC_OK) {
                String reData = EntityUtils.toString(response.getEntity());
                requestSampler.setResponseInfo(reData);
            }
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.error("Method failed:" + response.getStatusLine());
            }
        } catch (Exception e) {
            //发生网络异常
            TestReport.isPass = false;
            logger.error("Error Occurred!" + e.getMessage());
        }
    }
    //shenbingbing add end




}
