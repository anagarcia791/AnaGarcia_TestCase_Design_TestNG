package org.espn.tests;

import org.espn.pages.*;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateUserTest extends BaseTest {

    private final String NAME = "test-name";
    private final String LASTNAME = "test-last-name";
    private static String EMAIL = "test-email-16-@gmail.com";
    private final String PASSWORD = "test-TO-delete";

    public void setNewEmail() {
        int randomValue = (int) (Math.random() * 1000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    @Test(priority = 4)
    public void createNewUserToDeactivate() {
        setNewEmail();

        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.triggerForClickOnLoginButton();
        SingUpIFrame singUpIFrame = loginIFrame.triggerForClickOnSingUpButton();
        singUpIFrame.triggerUserSingUp(NAME, LASTNAME, EMAIL, PASSWORD);

        userOptionsIFrame = super.basePage.goToUserOptions();
        userOptionsIFrame.triggerForClickOnLogoutButton();
    }

    @Test(priority = 5)
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

    @Test(priority = 6)
    public void confirmUserIsDeactivated() {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.triggerForClickOnLoginButton();
        loginIFrame.triggerUserLogging(EMAIL, PASSWORD);
        checkThat("user is deactivated", loginIFrame.getEmailAccountDeactivated(), is(EMAIL));
    }
}
