package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkFlow extends WebOperations {
    @FindBy (css = ".promo-banner-container iframe")
    private WebElement iframeBanner;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement promoBannerCloseBtn;

    private static String EMAIL = "test-email-0-@gmail.com";

    public WorkFlow(WebDriver driver) {
        super(driver);
    }

    public void checkIfBannerInHomePage() {
        if (isElementPresent(".promo-banner-container")) {

            super.getDriver().switchTo().frame(iframeBanner);

            super.clickElement(promoBannerCloseBtn);
        }
    }

    public void setNewEmail() {
        int randomValue = (int) (Math.random() * 1000);
        EMAIL = "test-email-" + randomValue + "-@gmail.com";
    }

    public void loginAction(MainNavBar mainNavBar, String email, String password) {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        loginIFrame.clickConfirmLoginButton(email, password);
    }

    public void logoutAction(MainNavBar mainNavBar) {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
        userOptionsIFrame.reloadPage();

    }

    public String signupAction(MainNavBar mainNavBar, String name, String lastName, String password) {
        setNewEmail();

        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        SingUpIFrame singUpIFrame = loginIFrame.clickSingUpButton();
        singUpIFrame.fillSingUpInputs(name, lastName, EMAIL, password);
        singUpIFrame.clickConfirmSingUpButton();

        logoutAction(mainNavBar);

        return EMAIL;
    }
}
