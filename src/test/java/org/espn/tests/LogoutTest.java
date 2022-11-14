package org.espn.tests;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    @Test(priority = 3)
    public void logout() {
        System.out.println("logout");
    }
}
