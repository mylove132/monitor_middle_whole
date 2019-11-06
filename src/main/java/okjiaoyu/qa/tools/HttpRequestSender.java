package okjiaoyu.qa.tools;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiaozheng on 2016/5/23.
 */
public class HttpRequestSender {

    static {
        System.setProperty("log4j.configuration", "file:E:\\config\\logger\\pad-ui-dataSaver\\log4j.properties");
    }

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 通过GET方式发起http请求
     */
    @Test
    public void requestByGetMethod() {

        String url = "http://172.18.4.55:8080/qa_platform/testHistory/sendReport?testHistoryId=10181&mailReceiver=zhangxiaozheng@okjiaoyu.cn";
        String res = requestByGetMethod(url);
        logger.info("res:" + res);

    }

    public String requestByGetMethod(String url) {
        String responseString = "";
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        try {
            //用get方法发送http请求
            HttpGet get = new HttpGet(url);
            logger.info("执行get请求:...." + get.getURI());
            CloseableHttpResponse httpResponse = httpClient.execute(get);
            //发送get请求
            try {
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity) {
                    int status = httpResponse.getStatusLine().getStatusCode();

                    logger.info("响应状态码:" + status);
                    logger.info("-------------------------------------------------");
                    if (status == 200) {
                        responseString = EntityUtils.toString(entity);
                    } else {
                        responseString = httpResponse.getStatusLine() + "";
                    }
                    logger.info("响应内容:" + responseString);
                    logger.info("-------------------------------------------------");
                }
            } finally {
                httpResponse.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseString;
    }


    /**
     * POST方式发起http请求
     */
    @Test
    public void requestByPostMethod() {
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpPost post = new HttpPost("http://localhost/....");          //这里用上本机的某个工程做测试
            //创建参数列表
            List<NameValuePair> list = new ArrayList<>();
            list.add(new BasicNameValuePair("j_username", "admin"));
            list.add(new BasicNameValuePair("j_password", "admin"));
            //url格式编码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list, "UTF-8");
            post.setEntity(uefEntity);
            logger.info("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try {
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity) {
                    logger.info("-------------------------------------------------------");
                    logger.info(EntityUtils.toString(uefEntity));
                    logger.info("-------------------------------------------------------");
                }
            } finally {
                httpResponse.close();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                closeHttpClient(httpClient);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private CloseableHttpClient getHttpClient() {
        return HttpClients.createDefault();
    }

    private void closeHttpClient(CloseableHttpClient client) throws IOException {
        if (client != null) {
            client.close();
        }
    }
}
