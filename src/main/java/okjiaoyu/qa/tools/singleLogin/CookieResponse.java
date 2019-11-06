package okjiaoyu.qa.tools.singleLogin;

import org.apache.http.client.CookieStore;

import java.util.HashMap;
import java.util.Map;

public class CookieResponse {

    Map<String, String> cookies = new HashMap<>();

    CookieStore cookieStore;

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }
}
