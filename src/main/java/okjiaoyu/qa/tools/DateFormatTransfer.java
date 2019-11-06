package okjiaoyu.qa.tools;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangxiaozheng on 2016/6/1.
 */
public class DateFormatTransfer {


    public static Date convertString2Date(String dateString) {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return date;
    }

    @Test
    public void test() {
        System.out.print(convertString2Date("2016-05-31 19:02:36").getTime());
    }
}
