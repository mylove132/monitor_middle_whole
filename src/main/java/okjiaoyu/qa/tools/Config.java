package okjiaoyu.qa.tools;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Administrator on 2015/3/31.
 * Config
 */
public class Config {

    private Logger logger = Logger.getLogger(this.getClass());

    public static String static_value_fileName = "";

    @Test
    public void getOs() {
        Properties props = System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        logger.info("osName:" + osName);
        logger.info("osArch:" + osArch);
        logger.info("osVersion:" + osVersion);
    }

    public static boolean isOnWindows() {
        Properties props = System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        return osName.contains("Windows");
    }

    public static String getGzipFolderPath() {
        String path;
//        path =
        if (isOnWindows()) {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            path = getPropertiesData.getData("GzipFolderPath_Windows");
//            path = Config.getGlobalValue("GzipFolderPath_Windows");
        } else {
            GetPropertiesData getPropertiesData = new GetPropertiesData();
            path = getPropertiesData.getData("GzipFolderPath_Linux");
//            path = Config.getGlobalValue("GzipFolderPath_Linux");
        }
        return path;
    }

    public static String getProjectSetting(String str) {
        ParseXml apiXml = new ParseXml("/config/global.xml");
        String value = apiXml.getElementText("//" + str);
        return value;
    }

    public String getProjectSettingFile(String str) {
        ParseXml apiXml = new ParseXml("/config/global.xml");
        String value = apiXml.getElementText("//" + str);
        return value;
    }


    public static String getModuleConfig(String str) {
        ParseXml apiXml = new ParseXml(RunningParameter.settingFilePath);
        String value = apiXml.getElementText("//" + str);
        return value;
    }

    public static String getTeacherAccountConfig(String str) {
        ParseXml apiXml = new ParseXml(RunningParameter.settingFilePathforTeacher);
        String value = apiXml.getElementText("//" + str);
        return value;
    }

    public static String getGlobalValue(String str) {
        ParseXml apiXml = new ParseXml("/config/global.xml");
        String value = apiXml.getElementText("//" + str);
        return value;
    }

    public Map<String, String> getProperties(String filepath) {
        //resultMap
        Map<String, String> resultMap = new HashMap<>();
        Properties prop = new Properties();
//        InputStream in = this.getClass().getResourceAsStream("/IcisReport.properties");
        InputStream in = this.getClass().getResourceAsStream(filepath);
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set keyValue = prop.keySet();
        for (Iterator it = keyValue.iterator(); it.hasNext(); ) {
            String propKey = ( String ) it.next();
            resultMap.put(propKey, ( String ) prop.get(propKey));
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    public String getProperty(String filepath, String key) {
        Map<String, String> properties = getProperties(filepath);
        return properties.get(key);
    }

    @Test
    public void test() {
        String filepath = "/config/config.properties";

        System.out.println(getProperty(filepath, "uname"));
    }

    public static String getStaticValue(String str) {
        String xmlFilePath = "/config/static_value/" + static_value_fileName + ".xml";
        ParseXml apiXml = new ParseXml(xmlFilePath);
        String value = apiXml.getElementText("//" + str);
        return value;
    }

}
