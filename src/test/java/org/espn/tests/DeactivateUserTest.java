package org.espn.tests;

import org.espn.pages.*;
import org.espn.reporting.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateUserTest extends BaseTest {
    private String EMAIL = "";

    private void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Test(dataProvider = "signupData-provider", priority = 4)
    public void deactivateUser(String name, String lastName, String password) {
        Reporter.info("\n---------------starting deactivate user test---------------\n");

        Reporter.info("Sing up as precondition");
        String email = workFlow.signupAction(mainNavBar, name, lastName, password);
        setEMAIL(email);
        Reporter.info("Email of new user to deactivate: " + email);


        workFlow.loginAction(mainNavBar, EMAIL, password);

        UserOptionsIFrame userOptionsIFrame = super.mainNavBar.goToUserOptions();
        EspnProfileIFrame espnProfileIFrame = userOptionsIFrame.clickEspnProfileButton();
        AccountDeleteIFrame accountDeleteIFrame = espnProfileIFrame.triggerClickOnDeleteLink();
        checkThat("modal for confirm account delete is present", accountDeleteIFrame.getTitleOfAreYouSureIframe(), is("Are you sure?"));
        accountDeleteIFrame.clickConfirmDeletingButton();
        accountDeleteIFrame.reloadPage();

        Reporter.info("Logout as post condition");
        workFlow.logoutAction(mainNavBar);

        Reporter.info("\n---------------finalizing deactivate user test---------------\n");
    }

    @Test(dataProvider = "signupData-provider", priority = 5)
    public void confirmUserIsDeactivated(String name, String lastName, String password) {
        Reporter.info("\n---------------starting confirm user deactivated test---------------\n");

        UserOptionsIFrame userOptionsIFrame = super.mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        loginIFrame.clickConfirmLoginButton(EMAIL, password);

        checkThat("user is deactivated", loginIFrame.getEmailAccountDeactivated(), is(EMAIL));

        Reporter.info("\n---------------finalizing confirm user deactivated test---------------\n");
    }
}
