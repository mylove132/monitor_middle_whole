package okjiaoyu.qa.tools;

/**
 * Created by 晓 on 2015/7/6.
 * send http request
 **/

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import okjiaoyu.qa.persistance.model.RequestHistory;
import okjiaoyu.qa.persistance.model.TestCaseDetail;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import static okjiaoyu.qa.middle.auto.testcase.stupad.Pad.account_token;

public class APIHttpClient {

    private String proId;
    private String requestId;

    private Logger logger = Logger.getLogger(this.getClass());

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpClientContext context = new HttpClientContext();

    private HttpPost httppost = null;
    private HttpGet httpGet = null;
    private MultipartEntity multipartEntity = new MultipartEntity();
    private int httpStatusCode;

    public JSONObject getReJson() {
        return reJson;
    }

    private JSONObject reJson;


    /**
     * 接口地址
     * @param url
     */

    /**
     * submit the jsonObject value
     *
     * @ no return
     */

    public void executePostRequest(RequestSampler requestSampler) {
        logger.info("--------------- executePostRequest start -----------------");
        //Httppost
        httppost = new HttpPost(requestSampler.getRequestUrl());
        //请求json数据
        try {
            //add requestid to header
            //String requestId = "qa" + new Date().hashCode();
            requestId = generateRequestId(requestSampler.getRequestProId());
            //String requestId = "qa_" +proId+ (new Date().hashCode()&(0x7fffffff))+(int)((Math.random()*9+1)*100000);
            requestSampler.setRequestId(requestId);

            httppost.addHeader("requestid", requestId);
            httppost.addHeader("vs", "1.0.0.2");
            httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
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
                this.reJson = JSONObject.parseObject(reData);
                requestSampler.setResponseInfo(this.reJson.toString());
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

    public String executePostRequest(String requestUrl, JSONObject jsonObject, String proId) {
        logger.info("--------------- executePostRequest start -----------------");
        //Httppost
        httppost = new HttpPost(requestUrl);
        String resoponseEntityString = "000";
        //请求json数据FV
        try {
            //add requestid to header
            //String requestId = "qa" + new Date().hashCode();

            String requestId = "qa_" + proId + new Date().hashCode() + (int) ((Math.random() * 9 + 1) * 100);
            httppost.addHeader("requestid", requestId);
            httppost.setHeader("Content-Type", "application/json;charset=UTF-8");
            //httpEntity
            StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(jsonObject));
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httppost.setEntity(stringEntity);
            //post
            HttpResponse response = httpClient.execute(httppost);
            resoponseEntityString = EntityUtils.toString(response.getEntity());
            //result
        } catch (IOException e) {
            //发生网络异常
            logger.error("Network Exception Occurred!\n" + ExceptionUtils.getFullStackTrace(e));
        }
        logger.info("--------------- executePostRequest  complete -----------------");
        return resoponseEntityString;
    }


    public void getRequest(RequestSampler requestSampler) {  //String parameters

        httpGet = new HttpGet(requestSampler.getRequestUrl());
        try {
            //add requestid to header
            //requestSampler.setRequestId("qa" + new Date().hashCode() + "");
            requestId = generateRequestId(requestSampler.getRequestProId());
            requestSampler.setRequestId(requestId);
            httpGet.addHeader("requestid", requestId);
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpGet.addHeader("X-Requested-With", "XMLHttpRequest");
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
            requestSampler.setRequestInfo(JSONObject.toJSONString(requestSampler.getGetRequsetParams()));
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


    private RequestHistory buildNewRequestHistory(TestCaseDetail testCaseDetail) {
        // generate new requestHistory
        RequestHistory requestHistory = new RequestHistory();
        requestHistory.setEntityInterfaceName(testCaseDetail.getInterface_name());
        requestHistory.setEntityTestcaseName(testCaseDetail.getCase_name());
        requestHistory.setRequesturl(testCaseDetail.getInterface_url());
        requestHistory.setRequestdata(testCaseDetail.getUp_data());
        try {
            requestHistory.setEntityTestcaseId(testCaseDetail.getCase_id());
        } catch (NullPointerException e) {
            logger.info("testcaseId is null, maybe this is a debug test");
        }
        return requestHistory;
    }


    public void postFormdata(RequestSampler requestSampler) {  //String parameters
        httppost = new HttpPost(requestSampler.getRequestUrl());
        try {
            //add requestid to header
            //requestSampler.setRequestId("qa_" + new Date().hashCode() + "");
            // //requestSampler.setRequestId("qa_" + new Date().hashCode()+(int)((Math.random()*9+1)*100000));
            requestId = generateRequestId(requestSampler.getRequestProId());
            httppost.addHeader("requestid", requestId);
            //HttpEntity
            setFormFiles(requestSampler);
            setFormValuePair(requestSampler);
            httppost.setEntity(multipartEntity);
            //get cookies
            HttpResponse response = httpClient.execute(httppost, context);
            //save cookies to session
            CookieStore cookieStore = context.getCookieStore();
            logger.info("[CookieStore]:" + JSONObject.toJSONString(cookieStore));
            logger.info("[COOKIES IN CONTEXT]:" + JSONObject.toJSONString(cookieStore.getCookies()));
            if (!cookieStore.getCookies().isEmpty()) {
                requestSampler.setCookieStore(cookieStore);
            } else {
                logger.warn("no new cookies to save");
            }
            RunningParameter.cookieStore = cookieStore;
            //httpstatus
            this.httpStatusCode = response.getStatusLine().getStatusCode();
            requestSampler.setHttpStatus(this.httpStatusCode);
            //当获得正确响应时
            if (httpStatusCode == HttpStatus.SC_OK) {
                String reData = EntityUtils.toString(response.getEntity());
                logger.info(JSONObject.toJSONString(reData));
                this.reJson = JSONObject.parseObject(reData);
                requestSampler.setResponseInfo(this.reJson.toString());
            }
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.error("Method failed:" + response.getStatusLine());
            }
        } catch (IOException e) {
            //发生网络异常
            logger.error("Network Exception Occurred!\n");
            //网络错误
        }
    }

    public boolean isTestCasePass(JSONObject jsonObject, String checkeData) {
        CheckCondition checkCondition = new CheckCondition();
        return checkCondition.verify(jsonObject, checkeData);
    }

    /*
     * 中间层监控使用的发送HTTP POSt请求方法
     *
     * */
    public void postJson(RequestSampler requestSampler) {  //String parameters
        httppost = new HttpPost(requestSampler.getRequestUrl());
        //请求json数据
        String jsonString = requestSampler.getRequestInfo();
        if (jsonString != null && !"".equals(jsonString.trim()))//
        {
            try {
                //build httpPost with header and entity
                buildGzipHeader(requestSampler.getRequestProId(), requestSampler);
                buildGzipEntity(jsonString);
                //requestSampler.setRequestId(generateRequestId(requestSampler.getRequestProId()));
                //post
                setCookies();
                HttpResponse response = httpClient.execute(httppost);
                this.httpStatusCode = response.getStatusLine().getStatusCode();
                requestSampler.setHttpStatus(this.httpStatusCode);
                //当获得正确响应时
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
        } else {
            logger.error("httppost or requestJson is null");
        }
    }

    /*
     * 中间层监控使用的发送HTTP POSt请求方法（带过滤器）
     *
     * */
    public void postJsonTest(RequestSampler requestSampler) {  //String parameters
        httppost = new HttpPost(requestSampler.getRequestUrl());
        httppost.addHeader(HTTP.CONTENT_TYPE, "application/json");
        httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");
//        httppost.setHeader("requestid","qa_002455212441412");
        //请求json数据
        String jsonString = requestSampler.getRequestInfo();
        if (jsonString != null && !"".equals(jsonString.trim()))//
        {
            try {
                StringEntity se = new StringEntity(jsonString);
                System.out.print("jsonString----" + jsonString);

                se.setContentType("text/json");

                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

                httppost.setEntity(se);
                requestId = generateRequestId(proId);
                //String requestId = "qa_gzip_" + Math.absw(new Date().hashCode());
                // String requestId = "qa_" +proId+ new Date().hashCode()+(int)((Math.random()*9+1)*100000);
                httppost.addHeader("requestid", requestId);
                requestSampler.setRequestId(requestId);
                //build httpPost with header and entity
//                buildGzipHeader(requestSampler.getRequestProId(),requestSampler);
//                buildGzipEntity(jsonString);
                //requestSampler.setRequestId(generateRequestId(requestSampler.getRequestProId()));
                //post
                setCookies();
                HttpResponse response = httpClient.execute(httppost);
                this.httpStatusCode = response.getStatusLine().getStatusCode();
                requestSampler.setHttpStatus(this.httpStatusCode);
                //当获得正确响应时
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
        } else {
            logger.error("httppost or requestJson is null");
        }
    }

    private void buildGzipHeader(String proId, RequestSampler requestSampler) {
        requestId = generateRequestId(proId);
        //String requestId = "qa_gzip_" + Math.absw(new Date().hashCode());
        // String requestId = "qa_" +proId+ new Date().hashCode()+(int)((Math.random()*9+1)*100000);
        httppost.addHeader("requestid", requestId);
        requestSampler.setRequestId(requestId);
        httppost.addHeader("Api-Gzip", "1");
        if (RunningParameter.projectName.equals("stupad")) {
            httppost.addHeader("token", account_token);
//            httppost.addHeader("appversion", "2.6.1.4_tcon2.0-debug");
        }

    }

    private void buildGzipEntity(String jsonString) {
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setContentEncoding("UTF-8");
        entityBuilder.setStream(inputStream);
        entityBuilder.gzipCompress();
        httppost.setEntity(entityBuilder.build());
    }

    private String getPostHeaders() {
        Header[] headers = httppost.getAllHeaders();
        JSONObject headersJson = new JSONObject();
        for (Header header : headers) {
            headersJson.put(header.getName(), header.getValue());
        }
        return headersJson.toJSONString();
    }


 /*   private void buildGzipFormatPost(HttpPost post, String jsonString){
//        String requestId = "qa_gzip_" + new Date().hashCode();
        String requestId = "qa_" + new Date().hashCode()+(int)((Math.random()*9+1)*100000);
        httppost.addHeader("requestid", requestId);
        httppost.addHeader("Api-Gzip", "1");

        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes());
        EntityBuilder entityBuilder = EntityBuilder.create();
        entityBuilder.setContentEncoding("UTF-8");
        entityBuilder.setStream(inputStream);
        entityBuilder.gzipCompress();
        post.setEntity(entityBuilder.build());
    }*/

    //insert cookieStore
    public void setCookies() {
        if (RunningParameter.cookieStore != null) {
            httpClient = HttpClients.custom().setDefaultCookieStore(RunningParameter.cookieStore).build();
        }
    }

    private void setFormValuePair(RequestSampler requestSampler) throws UnsupportedEncodingException {
        if (!requestSampler.getFormValuePairs().isEmpty()) {
            Set set = requestSampler.getFormValuePairs().keySet();
            for (Iterator iter = set.iterator(); iter.hasNext(); ) {
                String key = (String) iter.next();
                String value = (String) requestSampler.getFormValuePairs().get(key);
                multipartEntity.addPart(key, new StringBody(value, Charset.forName("UTF-8")));
            }
            logger.info("[request formValuePair]:" + JSONObject.toJSONString(requestSampler.getFormValuePairs()));
        }
    }

    private void setFormFiles(RequestSampler requestSampler) {
        if (!requestSampler.getFormFiles().isEmpty()) {
            Set set = requestSampler.getFormFiles().keySet();
            for (Iterator iter = set.iterator(); iter.hasNext(); ) {
                String key = (String) iter.next();
                String value = (String) requestSampler.getFormFiles().get(key);
                multipartEntity.addPart(key, new FileBody(new File(value)));
            }
            logger.info("[request formFiles]:" + JSONObject.toJSONString(requestSampler.getFormFiles()));
        }
    }

    /*@Test
    public void executePostRequestOnGzipFormat(){
        logger.info("--------------- executePostRequestOnGzipFormat start -----------------");
        //requestUrl
        String requestUrl = "http://studentpad.xk12.cn/api/pad/user/login";
        //Httppost
        httppost = new HttpPost(requestUrl);
        //请求json数据
        try{
            //add requestid to header
            //String requestId = "qa_gzip_" + new Date().hashCode();
            String requestId = "qa_" + new Date().hashCode()+(int)((Math.random()*9+1)*100000);
            httppost.addHeader("requestid", requestId);
            httppost.addHeader("Api-Gzip", "1");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uname", "81951053306");
            jsonObject.put("pwd", "FlFOlXXrzEheiy8ep9zdJFsxqJOIwgoSbnkZThGe4IdsjMfoaikNc08pNlGDhCtAHzvX4naArwuKDmQX1w5S/pHagsK005gAVqoOAIl1SR+NyoB2y2j5D+18H9Fw5R/JcgTIL8Zwz9KC6dDLgiOvn/Lb1LCiUqqdwkIEheMpBbc=");

            InputStream inputStream = new ByteArrayInputStream(jsonObject.toJSONString().getBytes());
            EntityBuilder entityBuilder = EntityBuilder.create();
            entityBuilder.setContentEncoding("UTF-8");
            entityBuilder.setStream(inputStream);
            entityBuilder.gzipCompress();

            httppost.setEntity(entityBuilder.build());
            //post
            HttpResponse response = httpClient.execute(httppost);
            //response
            this.httpStatusCode = response.getStatusLine().getStatusCode();
            //Response data
            String resoponseEntityString = EntityUtils.toString(response.getEntity());
            logger.info("[resoponseEntityString]:" + resoponseEntityString);
        }catch(IOException e){
            //发生网络异常
            logger.error("Exception Occurred!\n" + ExceptionUtils.getFullStackTrace(e));
        }
        logger.info("--------------- executePostRequestOnGzipFormat  complete -----------------");
    }*/

    public String generateRequestId(String proId) {
        if (proId == null) {
            proId = "00";
        }
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(10);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(10);
        requestId = "qa_" + proId + nf.format(UUID.randomUUID().hashCode() & (0x7fffffff));
        return requestId;
    }
}