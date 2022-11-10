package org.espn.tests;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test
    public void logout() {
        log.info("Test" + "\n" + "* If user is logged out:" + "\n" +
                "  Skip" + "\n" +
                "* If user is logged in:" + "\n" +
                "  Click btn LOGOUT" + "\n");
    }
}
