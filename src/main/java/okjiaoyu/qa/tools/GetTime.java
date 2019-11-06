package okjiaoyu.qa.tools;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 获取当前时间
 */
public class GetTime {


    private Logger logger = Logger.getLogger(this.getClass());


    public static void main(String[] args) {
        String time = new GetTime().getValidDateStr(new Date());
        System.out.println(time);
    }


    /**
     * 时间转换
     *
     * @param data
     * @return
     */
    public String getValidDateStr(Date data) {
        String sDate = "";
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        try {
            Date date = sdf1.parse(sdf1.format(data));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sDate = sdf.format(date);
        } catch (ParseException e) {
            logger.error("日期装换方法是把：" + data + "******" + e);
        }
        return sDate;
    }
}
