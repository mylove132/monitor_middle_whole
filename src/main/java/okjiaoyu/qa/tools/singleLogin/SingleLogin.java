package okjiaoyu.qa.tools.singleLogin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static io.restassured.config.RestAssuredConfig.config;



//单点登录
public class SingleLogin {

    private String url;
    private String userName;
    private String passWord;
    private String ssoUrl;
    private Map<String, String> cookies = new HashMap<>();


    public SingleLogin() {

    }


    public SingleLogin(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;

        RestAssured.config = config().redirect(redirectConfig().followRedirects(false));

        System.setProperty("sun.net.client.defaultConnectTimeout", String
                .valueOf(10000));// （单位：毫秒）
        System.setProperty("sun.net.client.defaultReadTimeout", String
                .valueOf(10000)); // （单位：毫秒）

    }


    public static void main(String[] args) {

//        new SingleLogin("https://jigou.okjiaoyu.cn", "62951278505", "Okay@123").login();
//        new SingleLogin("https://jiaoshi.okjiaoyu.cn","61951414691","Okay@123").login();
        new SingleLogin("https://jiaoshi-hotfix.xk12.cn", "61951383911", "Okay@123").login();

//        new SingleLogin("https://edu-hotfix.xk12.cn","61951280017","Okay@123").login();
    }

    /**
     * 判断环境
     *
     * @param url
     * @return
     */
    private static String judgeEnv(String url) {
        System.out.println("获取 ssoUrl");
        String ssoUrl = "";
        if (url.contains("hotfix")) {

            ssoUrl = "https://sso-hotfix.xk12.cn/login?service=" + url + "/";

        } else if (url.contains("dev")) {
            ssoUrl = "https://sso-qa-dev.xk12.cn/login?service=" + url + "/";

        } else {

            ssoUrl = "https://sso.okjiaoyu.cn/login?service=" + url + "/";
        }
        System.out.println("[ssoUrl]==" + ssoUrl);

        return ssoUrl;
    }

    /**
     * 登录成功返回cookies
     */
    public CookieResponse login() {
        CookieResponse cookieResponse = new CookieResponse();

        ssoUrl = judgeEnv(url);
        Map<String, String> loginCookies = getCookies();
        cookieResponse.setCookies(loginCookies);

        String host = url.split("//")[1].trim();
        CookieStore cookieStore = new BasicCookieStore();
        for (Object str : cookies.keySet()) {

            //给cookie设置超时时间 +1小时
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.HOUR, 1);


            BasicClientCookie cookie = new BasicClientCookie(str.toString(), cookies.get(str));
            cookie.setDomain(host);
            cookie.setPath("/");
            cookie.setSecure(true);
            cookie.setVersion(0);
            cookie.setExpiryDate(cal.getTime());

            cookieStore.addCookie(cookie);
        }

        cookieResponse.setCookieStore(cookieStore);

        return cookieResponse;
    }

    //获取cookies
    public Map<String, String> getCookies() {
        //获取  lt/execution/_eventId
        System.out.println("获取 lt/execution/_eventId");
        Map<String, String> params = new HashMap<>();
        try {
            params = new Weather(ssoUrl).run();
        } catch (Exception e) {
            System.out.println("获取SSO数据出错");
            e.printStackTrace();
        }
        //请求 TGC 数据
        String platformType = "";

        if (url.contains("jiaoshi")) {
            platformType = "teacher";

        } else if (url.contains("edu") || url.contains("public")) {
            platformType = "org";

        } else if (url.contains("jigou") || url.contains("private")) {

            platformType = "org";
        } else {
            System.out.println("platformType is null");
        }

        System.out.println("获取 locationURL");
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("loginType", "1");
        requestParam.put("platformType", platformType);//teacher/org
        requestParam.put("username", userName);
        requestParam.put("password", passWord);
        requestParam.put("pictureVerifyCode", "performance");//performance
        requestParam.put("phone", "");
        requestParam.put("traceno", "");
        requestParam.put("phoneVerifyCode", "");
        requestParam.put("lt", params.get("lt"));
        requestParam.put("execution", params.get("execution"));
        requestParam.put("_eventId", params.get("_eventId"));

        Response response = post(ssoUrl, cookies, requestParam);
        cookies.putAll(response.getCookies());
        String location = response.getHeaders().get("Location").getValue();
        System.out.println("[locationURL]==" + location);
        System.out.println("获取 cookies");
        Response ticketResponse = get(new HashMap<String, String>(), location);
        System.out.println("[cookies]==" + ticketResponse.getCookies());
        cookies.putAll(ticketResponse.getCookies());
        Map<String, String> loginCookies = ticketResponse.getCookies();

        return loginCookies;
    }


    public Response post(String host, Map<String, String> cookies, Map<String, String> params) {

        RestAssured.useRelaxedHTTPSValidation();
        Response response = null;
        try {
            response = given()
//                    .log().all()
                    .cookies(cookies)
                    .contentType(ContentType.URLENC)
                    .params(params)
                    .when()
                    .post(host);
        } catch (Exception e) {

            System.out.println("[requestFail]==" + e.getLocalizedMessage());
            e.printStackTrace();
        }
        System.out.println("[响应时间]==" + response.getTime());
        return response;
    }


    /**
     * GET请求方法
     *
     * @param getPath
     * @return
     */
    public Response get(Map<String, String> cookies, String getPath) {

        RestAssured.useRelaxedHTTPSValidation();
        Response response = null;
        try {
            response = given()
//                    .log().all()
                    .cookies(cookies)
                    .when()
                    .get(getPath);

        } catch (Exception e) {
            System.out.println("[requestFail]==" + e.getLocalizedMessage());
            e.printStackTrace();
        }

        System.out.println("[响应时间]==" + response.getTime());

        return response;
    }
}
