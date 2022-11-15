package org.espn.tests;

import org.espn.pages.UserOptionsIFrame;
import org.espn.pages.LoginIFrame;
import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class ActionsForActiveUserTest extends BaseTest {
    @Test(dataProvider = "userLoginData-provider", priority = 1)
    public void login(String email, String password) {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.triggerForClickOnLoginButton();
        checkThat("modal is present", loginIFrame.areLoginFormElementsDisplayed(), is(true));
        loginIFrame.triggerUserLogging(email, password);
        userOptionsIFrame = super.basePage.goToUserOptions();
        checkThat("login succeeded", userOptionsIFrame.getUsernameLogged(), is("Ana!"));
        userOptionsIFrame.goFromUserOptionsToBasePage();
    }

    @Test(priority = 2)
    public void navigationToWatchPage() {
        WatchPage watchPage = super.basePage.goToWatchPage();
        checkThat("more than one carousel is present", watchPage.areWatchPageElementsDisplayed(), is(true));
        watchPage.clickOnCarouselSecondCard();
        checkThat("choose supplier frame is present", watchPage.isExitFromChooseSupplierBtnDisplayed(), is(true));
        watchPage.clickOnExitFromChooseSupplier();
        watchPage.goToBasePage();
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        checkThat("user still connected", userOptionsIFrame.getUsernameLogged(), is("Ana!"));
        userOptionsIFrame.goFromUserOptionsToBasePage();
    }

    @Test(priority = 3)
    public void Logout() {
        UserOptionsIFrame userOptionsIFrame = super.basePage.goToUserOptions();
        userOptionsIFrame.triggerForClickOnLogoutButton();
        userOptionsIFrame.reloadPage();
        userOptionsIFrame = super.basePage.goToUserOptions();
        checkThat("user is disconnected", userOptionsIFrame.isUserDisconnected(), is(true));
        userOptionsIFrame.goFromUserOptionsToBasePage();
        userOptionsIFrame.reloadPage();
    }
}
