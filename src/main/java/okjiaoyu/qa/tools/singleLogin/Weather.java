package okjiaoyu.qa.tools.singleLogin;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Weather {


    private Map<String, String> cookies = new HashMap<>();

    private String urlString;
    private String lt;
    private String execution;
    private String _eventId;

    public Weather(String urlString) {
        this.urlString = urlString;
    }

    public static void main(String[] args) throws Exception {

        Weather client = new Weather("https://sso-hotfix.xk12.cn/login?service=https://jiaoshi-hotfix.xk12.cn/");
        client.run();
    }


    public Map<String, String> run() throws Exception {

        URL url = new URL(urlString);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream(), "utf8"));
        String line;

        while ((line = reader.readLine()) != null) {

            if (line.contains("name=\"lt\"")) {
                lt = line.split("value=")[1].replace("\"", "").replace("/>", "").trim();
                System.out.println("[lt]==" + lt);
            }
            if (line.contains("name=\"execution\"")) {
                execution = line.split("value=")[1].replace("\"", "").replace("/>", "").trim();
                System.out.println("[execution]==" + execution);
            }
            if (line.contains("name=\"_eventId\"")) {
                _eventId = line.split("value=")[1].replace("\"", "").replace("/>", "").trim();
                System.out.println("[_eventId]==" + _eventId);
            }
        }

        cookies.put("lt", lt);
        cookies.put("execution", execution);
        cookies.put("_eventId", _eventId);

        return cookies;
    }


}
