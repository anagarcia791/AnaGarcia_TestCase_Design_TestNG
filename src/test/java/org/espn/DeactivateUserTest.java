package org.espn;

import org.testng.annotations.Test;

public class DeactivateUserTest extends AppTest{
    @Test
    public void deactivateUser() {
        log.info("Test" + "\n" + "* If user is logged out:" + "\n" +
                "  Implement login method" + "\n" +
                "  Then click btn DEACTIVATE" + "\n" +
                "  Wait for confirmation message" + "\n" +
                "  Try to log in to confirm the account is deactivate" + "\n");
    }
}
