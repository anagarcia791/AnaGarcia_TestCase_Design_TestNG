package org.espn.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseTest {
    protected static Logger log = LoggerFactory.getLogger(BaseTest.class);

    @DataProvider(name = "usersLoginData-provider")
    public Object[][] getUsersLoginData() {
        return new Object[][]{{"user_1@email.com", "user_1"}};
    }

    @BeforeSuite
    public void initialSetUp() {
        log.info("BeforeSuite" + "\n" + "Open browser" + "\n" +
                "Tab of https://www.espn.com.co/ page open" + "\n");
    }

    @BeforeTest
    public void isAccountValid() {
        log.info("BeforeTest" + "\n" + "Check if account is valid" + "\n");
    }

    @BeforeMethod
    public void isUserLoggedIn() {
        log.info("BeforeMethod" + "\n" + "Check if user is logged in" + "\n");
    }

    @AfterMethod
    public void isUserLoggedOut() {
        log.info("AfterMethod" + "\n" + "Check if user is logged out" + "\n");
    }

    @AfterSuite
    public void tearDown() {
        log.info("AfterSuite" + "\n" + "Clean up all Cookies" + "\n" +
                "Close browser" + "\n");
    }
}
