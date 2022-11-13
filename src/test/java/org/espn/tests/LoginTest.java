package org.espn.tests;

import org.espn.pages.HomePage;
import org.espn.pages.LoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "usersLoginData-provider")
    public void login(String email, String password) {
        HomePage home = super.basePage.actionForClickUserButton();
        LoginPage loginPage = home.actionForClickLoginButton();
        loginPage.triggerUserLogging(email,password);
        checkThat("test 1", home.getUsernameLogged(), is(" Ana!"));
    }
}
