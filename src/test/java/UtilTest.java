
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zhangxiaozheng on 2016/7/21.
 */
public class UtilTest {

    private Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void indexOfString() {
        String str = "abcdefgd";
        int index = str.indexOf("d");
        int lastindex = str.lastIndexOf("d");
        logger.info("index:" + index);
        logger.info("lastindex:" + lastindex);
        String newStr = str.substring(index + 1, lastindex);
        logger.info("newStr:" + newStr);
    }

    @Test
    public void test() {
        String token = "8114e446d739794d1ca19683deaa46e91a";
        logger.info(buildExpiredToken(token));

    }

    private String buildExpiredToken(String token) {
        return token.substring(0, (token.length() - 1)) + "e";
    }
}
