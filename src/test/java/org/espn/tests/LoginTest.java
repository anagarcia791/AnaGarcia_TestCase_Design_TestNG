package org.espn.tests;

import org.espn.pages.HomePage;
import org.espn.pages.LoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "usersLoginData-provider", priority = 1)
    public void login(String email, String password) {
        System.out.println("khe llega " + basePage);

        HomePage home = super.basePage.actionForClickUserButton();
        LoginPage loginPage = home.actionForClickLoginButton();
        loginPage.triggerUserLogging(email, password);
        home = super.basePage.actionForClickUserButton();
        checkThat("Login succeeded", home.getUsernameLogged(), is("Ana!"));
    }
}
