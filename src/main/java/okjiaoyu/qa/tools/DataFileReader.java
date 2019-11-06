package okjiaoyu.qa.tools;

import com.alibaba.fastjson.JSONObject;
import okjiaoyu.qa.domain.RequestSampler;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 码农小争
 * FileReader.java
 * 2015年8月27日11:41:41
 */
public class DataFileReader {

    public DataFileReader() {

    }

    Logger logger = Logger.getLogger(this.getClass());


    public List readTxtFile(String filePath) {
        List stringList = new ArrayList<String>();
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    stringList.add(lineTxt);
                    System.out.println(lineTxt);
                }
                read.close();
                bufferedReader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return stringList;
    }

    public Map<String, String> getParms(String line) {
        //get info
        Map<String, String> map = new HashMap<>();
        String[] array = line.split(",");
//        logger.info("uname:" + filterUnNumber(array[0].trim()));
//        long u = Long.parseLong(array[0].trim());
        map.put("uname", filterUnNumber(array[0].trim()));
        map.put("pwd", array[1].trim());
        map.put("uid", array[2].trim());
        map.put("token", array[3].trim());
        return map;
    }

    public Map<String, String> getToken(String str) {
        //return map with new token
        Map<String, String> map = getParms(str);
        //make data for login
        JSONObject json = new JSONObject();
        json.put("uname", map.get("uname"));
        json.put("pwd", map.get("pwd"));
//        json.putAll(Pad.account_commonUp);
        //requestSampler
        RequestSampler rs = new RequestSampler();
        rs.setTestCaseName("更新uid和token");
        rs.setType(2);
        rs.setRequestUrl("http://studentpad.xk12.cn/api/pad/user/login");
        rs.setRequestInfo(json.toJSONString());
//        logger.info(rs.getRequestInfo());
        rs.post();
//        logger.info(rs.getResponseInfo());
        //response
        JSONObject json_response = JSONObject.parseObject(rs.getResponseInfo());
        String newToken = json_response.getJSONObject("data").get("token").toString();
        map.remove("token");
        map.put("token", newToken);
        //return
        return map;
    }

//    public List<String> updateToken(String filePath){
//        List<String> datalist = new ArrayList<>();
//        try {
//            String encoding="UTF-8";
//            File file = new File(filePath);
//            if(file.isFile() && file.exists()){ //判断文件是否存在
//                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
//                BufferedReader bufferedReader = new BufferedReader(read);
//                String lineTxt = null;
//                while((lineTxt = bufferedReader.readLine().trim()) != null){
//                    datalist.add(lineTxt);
//                }
//                read.close();
//            }else{
//                logger.error("找不到指定的文件");
//            }
//        } catch (Exception e) {
//            logger.error("读取文件内容出错");
//            e.printStackTrace();
//        }
//        return datalist;
//    }


//    @Test
//    public void updateTokenTest(){
//        int count = 0;
//        List<String> datalist = updateToken("E:\\users.txt");
//        for(int i = 0; i < datalist.size(); i++){
//            try{
//                String lineTxt = datalist.get(i);
//                logger.info("lineTxt:" + lineTxt);
//                Map<String, String> map = getToken(lineTxt);
//                String output = map.get("uname") + "," + map.get("pwd") + "," + map.get("uid") + "," +
//                        map.get("token") + ",other";
//                DataPrint2File.filePrint(output, "E:\\abc.txt");
//                logger.info("[output]:" + output);
//                count++;
//                logger.info("This is " + count + "th data!");
//                logger.info("---------- " + count + "th end -----------");
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }
//
//    }


    @Test
    public void test() {
        String result = filterUnNumber("!32432342432");
        logger.info(result);
    }

    public String filterUnNumber(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        //替换与模式匹配的所有字符（即非数字的字符将被""替换）
        str = m.replaceAll("").trim();
//        str.replaceAll("[^0-9]", "");
        return str;
    }


}
