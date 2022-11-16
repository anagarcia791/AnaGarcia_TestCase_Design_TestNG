package org.espn.tests;

import org.espn.pages.UserOptionsIFrame;
import org.espn.pages.LoginIFrame;
import org.espn.pages.WatchPage;
import org.espn.reporting.Reporter;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class ActionsForActiveUserTest extends BaseTest {
    @Test(dataProvider = "userLoginData-provider", priority = 1)
    public void login(String email, String password) {
        Reporter.info("\n---------------starting login test---------------\n");

        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        checkThat("login modal is present", loginIFrame.areLoginFormElementsDisplayed(), is(true));
        loginIFrame.clickConfirmLoginButton(email, password);
        userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("login succeeded", userOptionsIFrame.getUsernameLogged(), is("Ana!"));

        Reporter.info("Logout as post condition");
        workFlow.logoutAction(mainNavBar);

        Reporter.info("\n---------------finalizing login test---------------\n");
    }

    @Test(dataProvider = "userLoginData-provider", priority = 2)
    public void navigationToWatchPage(String email, String password) {
        Reporter.info("\n---------------starting watch page test---------------\n");


        Reporter.info("Login as precondition");
        workFlow.loginAction(mainNavBar, email, password);

        Reporter.info("Navigating to: watch page");
        WatchPage watchPage = mainNavBar.goToWatchPage();

        checkThat("more than one carousel is present", watchPage.areWatchPageElementsDisplayed(), is(true));
        checkThat("title present in each carousel cards", watchPage.isCarouselCardsTitleDisplayed(), is(true));
        watchPage.clickCarouselCard(1);
        checkThat("choose supplier frame is present", watchPage.isExitFromChooseSupplierBtnDisplayed(), is(true));
        watchPage.clickExitFromChooseSupplier();

        Reporter.info("Navigating to: home page");
        watchPage.goToPreviousPage();

        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("user still connected", userOptionsIFrame.getUsernameLogged(), is("Ana!"));

        Reporter.info("Logout as post condition");
        workFlow.logoutAction(mainNavBar);

        Reporter.info("\n---------------finalizing watch page test---------------\n");
    }

    @Test(dataProvider = "userLoginData-provider", priority = 3)
    public void Logout(String email, String password) {
        Reporter.info("\n---------------starting logout test---------------\n");

        Reporter.info("Login as precondition");
        workFlow.loginAction(mainNavBar, email, password);

        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
        userOptionsIFrame.reloadPage();

        userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("user is disconnected", userOptionsIFrame.isUserDisconnected(), is(true));
        userOptionsIFrame.reloadPage();

        Reporter.info("\n---------------finalizing logout test---------------\n");
    }
}
