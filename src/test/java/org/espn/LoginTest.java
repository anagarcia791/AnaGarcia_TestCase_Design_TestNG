package org.espn;

import org.testng.annotations.Test;

public class LoginTest extends AppTest {
    @Test(dataProvider = "usersLoginData-provider")
    public void login(String email, String password) {
        log.info("Test" + "\n" + "* If user is logged out:" + "\n" +
                    "  Take " + email + " and " + password + "\n" +
                    "  Then click btn LOGIN" + "\n" +
                    "  Finally click btn LOGOUT" + "\n" +
                    "* If user is logged in:" + "\n" +
                    "  Click btn LOGOUT" + "\n");
    }
}
