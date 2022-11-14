package org.espn.tests;

import org.espn.pages.UserOptionsIFrame;
import org.espn.pages.LoginIFrame;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "usersLoginData-provider", priority = 1)
    public void login(String email, String password) {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.actionForClickLoginButton();
        checkThat("modal is present", loginIFrame.areLoginFormElementsDisplayed(), is(true));
        loginIFrame.triggerUserLogging(email, password);
        userOptionsIFrame = super.basePage.goToUserOptions();
        checkThat("Login succeeded", userOptionsIFrame.getUsernameLogged(), is("Ana!"));
        userOptionsIFrame.goFromUserOptionsToBasePage();
    }
}
