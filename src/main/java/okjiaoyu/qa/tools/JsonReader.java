package okjiaoyu.qa.tools;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 晓 on 2015/7/9.
 */
public class JsonReader {
    public static String readFile(String filepath) {

        File file = new File(filepath);
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        //buffer.append("{");
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        //buffer.append("}");

        System.out.println(buffer.toString());
        JSONObject json = JSONObject.parseObject(buffer.toString());
        return json.toString();
    }

    public static String getErrorCode(JSONObject json) {
        String meta = json.get("meta").toString();
        JSONObject metaJson = JSONObject.parseObject(meta);
        return metaJson.get("ecode").toString();
    }

    public static String getToken(JSONObject jsonString) {
        String meta = jsonString.get("data").toString();
        JSONObject metaJson = JSONObject.parseObject(meta);
        return metaJson.get("token").toString();
    }

//    @Test
//    public void test(){
//        readFile("E:\\b.json");
//    }
}
