package okjiaoyu.qa.tools;

import org.apache.log4j.Logger;

/**
 * Created by zhang_000 on 2015/8/13.
 */
public class MyLogger {
    public Logger getLogger() {
        return logger;
    }

    private Logger logger = Logger.getLogger(this.getClass());
}
