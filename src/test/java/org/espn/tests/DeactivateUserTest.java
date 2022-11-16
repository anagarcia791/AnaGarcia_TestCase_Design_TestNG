package org.espn.tests;

import org.espn.pages.*;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class DeactivateUserTest extends BaseTest {

    private final String NAME = "test-name";
    private final String LASTNAME = "test-last-name";
    private static String EMAIL = "test-email-0-@gmail.com";
    private final String PASSWORD = "test-TO-delete";

    public void setNewEmail() {
        int randomValue = (int) (Math.random() * 1000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    @Test(priority = 4)
    public void createNewUserToDeactivate() {
        setNewEmail();

        UserOptionsIFrame userOptionsIFrame = super.mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        SingUpIFrame singUpIFrame = loginIFrame.clickSingUpButton();
        singUpIFrame.clickConfirmSingUpButton(NAME, LASTNAME, EMAIL, PASSWORD);

        userOptionsIFrame = super.mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
        userOptionsIFrame.reloadPage();
    }

    @Test(priority = 5)
    public void deactivateUser() {
        UserOptionsIFrame userOptionsIFrame = super.mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        loginIFrame.clickConfirmLoginButton(EMAIL, PASSWORD);
        userOptionsIFrame = super.mainNavBar.goToUserOptions();
        EspnProfileIFrame espnProfileIFrame = userOptionsIFrame.clickEspnProfileButton();
        AccountDeleteIFrame accountDeleteIFrame = espnProfileIFrame.triggerClickOnDeleteLink();
        checkThat("modal for confirm account delete is present", accountDeleteIFrame.getTitleOfAreYouSureIframe(), is("Are you sure?"));
        accountDeleteIFrame.clickConfirmDeletingButton();
        accountDeleteIFrame.reloadPage();

        userOptionsIFrame = super.mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
        userOptionsIFrame.reloadPage();
    }

    @Test(priority = 6)
    public void confirmUserIsDeactivated() {
        UserOptionsIFrame userOptionsIFrame = super.mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        loginIFrame.clickConfirmLoginButton(EMAIL, PASSWORD);
        checkThat("user is deactivated", loginIFrame.getEmailAccountDeactivated(), is(EMAIL));
    }
}
