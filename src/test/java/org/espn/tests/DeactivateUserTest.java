package org.espn.tests;

import org.espn.pages.AccountDeleteIFrame;
import org.espn.pages.EspnProfileIFrame;
import org.espn.pages.LoginIFrame;
import org.espn.pages.UserOptionsIFrame;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateUserTest extends BaseTest {
    private final String EMAIL = "test-email-16-@gmail.com";
    private final String PASSWORD = "test-TO-delete";

    @Test(priority = 4)
    public void deactivateUser() {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.triggerForClickOnLoginButton();
        loginIFrame.triggerUserLogging(EMAIL, PASSWORD);
        userOptionsIFrame = super.basePage.goToUserOptions();
        EspnProfileIFrame espnProfileIFrame = userOptionsIFrame.triggerForClickOnEspnProfileButton();
        AccountDeleteIFrame accountDeleteIFrame = espnProfileIFrame.triggerClickOnDeleteLink();
        checkThat("modal for confirm account delete is present", accountDeleteIFrame.getTitleOfAreYouSureIframe(), is("Are you sure?"));
        accountDeleteIFrame.triggerClickOnDeletingConfirmButton();
        accountDeleteIFrame.switchToDeletedAccountOkIFrameDOM();
        accountDeleteIFrame.triggerClickOnDeletedAccountOkButton();
    }

    @Test(priority = 5)
    public void confirmUserIsDeactivated() {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.triggerForClickOnLoginButton();
        loginIFrame.triggerUserLogging(EMAIL, PASSWORD);
        checkThat("user is deactivated", loginIFrame.getEmailAccountDeactivated(), is(EMAIL));
    }
}
