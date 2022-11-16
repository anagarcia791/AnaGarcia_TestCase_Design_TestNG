package org.espn.tests;

import org.espn.pages.UserOptionsIFrame;
import org.espn.pages.LoginIFrame;
import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class ActionsForActiveUserTest extends BaseTest {
    @Test(dataProvider = "userLoginData-provider", priority = 1)
    public void login(String email, String password) {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        checkThat("modal is present", loginIFrame.areLoginFormElementsDisplayed(), is(true));
        loginIFrame.clickConfirmLoginButton(email, password);
        userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("login succeeded", userOptionsIFrame.getUsernameLogged(), is("Ana!"));
        mainNavBar.clickUserButton();
    }

    @Test(priority = 2)
    public void navigationToWatchPage() {
        // HACER LOGIN
        WatchPage watchPage = mainNavBar.goToWatchPage();
        checkThat("more than one carousel is present", watchPage.areWatchPageElementsDisplayed(), is(true));
        checkThat("title present in each carousel cards", watchPage.isCarouselCardsTitleDisplayed(), is(true));
        watchPage.clickCarouselCard(1);
        checkThat("choose supplier frame is present", watchPage.isExitFromChooseSupplierBtnDisplayed(), is(true));
        watchPage.clickExitFromChooseSupplier();
        watchPage.goToPreviousPage();
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("user still connected", userOptionsIFrame.getUsernameLogged(), is("Ana!"));
    }

    @Test(priority = 3)
    public void Logout() {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
        userOptionsIFrame.reloadPage();
        userOptionsIFrame = mainNavBar.goToUserOptions();
        checkThat("user is disconnected", userOptionsIFrame.isUserDisconnected(), is(true));
        mainNavBar.clickUserButton();
        userOptionsIFrame.reloadPage();
    }
}
