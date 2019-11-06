package okjiaoyu.qa.middle.auto.testcase.parentApp;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.base.TestBase;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.middle.auto.testcase.parentApp.parent.ParentApp_parent;
import okjiaoyu.qa.tools.APIHttpClient;
import okjiaoyu.qa.tools.GetPropertiesData;
import okjiaoyu.qa.tools.RunningParameter;
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

import java.io.IOException;
import java.net.URI;

/**
 * shenbingbing add 2019/02/19
 * 为了不再公共方法里面添加内容，自己写个公共方法，添加请求头，以及不同个的路径等
 */
public class CommonUtils extends  ParentApp_parent{
    private HttpGet httpGet = null;
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpClientContext context = new HttpClientContext();
    private int httpStatusCode;
    private String requestId;
    private HttpPost httppost = null;

    //专用 get请求 start

    public void getRequest(RequestSampler requestSampler) {  //String parameters

        httpGet = new HttpGet(requestSampler.getRequestUrl());
        try {
            //add requestid to header
            //requestSampler.setRequestId("qa" + new Date().hashCode() + "");
            requestId = new APIHttpClient().generateRequestId(requestSampler.getRequestProId());
            requestSampler.setRequestId(requestId);
            httpGet.addHeader("requestid", requestId);
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("X-Requested-With", "XMLHttpRequest");
            httpGet.addHeader( "token",account_token );
            if ("08".equals(requestSampler.getRequestProId())) {
                GetPropertiesData getPropertiesData = new GetPropertiesData();
                httpGet.addHeader("referer", getPropertiesData.getData("referer"));
            }
            //add getRequestParam
            NameValuePair requestidPair = new BasicNameValuePair("requestid", requestSampler.getRequestId());
            requestSampler.getGetRequsetParams().add(requestidPair);
            String str = EntityUtils.toString(new UrlEncodedFormEntity(requestSampler.getGetRequsetParams()));
            httpGet.setURI(new URI(httpGet.getURI().toString() + "?" + str));
            //保存上行参数数据
            requestSampler.setRequestInfo( JSONObject.toJSONString(requestSampler.getGetRequsetParams()));
            //post
            HttpResponse response = httpClient.execute(httpGet);

            CookieStore cookieStore = context.getCookieStore();
            //http status code
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
    //专用 end

   //post 请求
    public void executePostRequestUtil(RequestSampler requestSampler) {
        logger.info("--------------- executePostRequest start -----------------");
        //Httppost
        httppost = new HttpPost(requestSampler.getRequestUrl());
        //请求json数据
        try {
            //add requestid to header
            //String requestId = "qa" + new Date().hashCode();
            requestId = new APIHttpClient().generateRequestId(requestSampler.getRequestProId());
            //String requestId = "qa_" +proId+ (new Date().hashCode()&(0x7fffffff))+(int)((Math.random()*9+1)*100000);
            requestSampler.setRequestId(requestId);

            httppost.addHeader("requestid", requestId);
            httppost.addHeader("vs", "1.0.0.2");
            httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
            httppost.addHeader("token", account_token);
            //httpEntity
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(JSONObject.parseObject(requestSampler.getRequestInfo())));
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httppost.setEntity(stringEntity);
            //post
            HttpResponse response = httpClient.execute(httppost);
            //http status code
            this.httpStatusCode = response.getStatusLine().getStatusCode();
            requestSampler.setHttpStatus(this.httpStatusCode);
            //当获得正确响应时
            if (httpStatusCode == HttpStatus.SC_OK) {
                String reData = EntityUtils.toString(response.getEntity());
                requestSampler.setResponseInfo(JSONObject.parseObject(reData).toString());
            }
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.error("Method failed:" + response.getStatusLine());
            }
            //result
        } catch (IOException e) {
            //发生网络异常
            logger.error("Network Exception Occurred!\n" + ExceptionUtils.getFullStackTrace(e));
        }
        logger.info("--------------- executePostRequest  complete -----------------");
    }

}
