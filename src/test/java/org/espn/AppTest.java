package org.espn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class AppTest {
    protected static Logger log = LoggerFactory.getLogger(AppTest.class);

    @BeforeSuite
    public void isPageOpen() {
        log.info("\nOpen browser" + "\n" +
                "Tab of https://www.espn.com.co/ page open" + "\n");
    }
}
