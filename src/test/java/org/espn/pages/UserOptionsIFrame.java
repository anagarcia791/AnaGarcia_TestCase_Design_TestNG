package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserOptionsIFrame extends BasePage {
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "ul.account-management li:nth-child(7)")
    private WebElement loginButton;

    @FindBy(css = "ul.account-management li:nth-child(9)")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    public UserOptionsIFrame(WebDriver driver) {
        super(driver);
    }

    private boolean isUserLabelOfflineDisplayed() {
        super.waitForVisibility(userLabelOffline);
        return userLabelOffline.isDisplayed();
    }

    private boolean isUserLabelOnlineDisplayed() {
        super.waitForVisibility(userLabelOnline);
        return userLabelOnline.isDisplayed();
    }

    private boolean isLoginButtonDisplayed() {
        super.waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }

    private boolean isLogoutButtonDisplayed() {
        super.waitForVisibility(logoutButton);
        return logoutButton.isDisplayed();
    }

    public boolean isUserDisconnected() {
        return isUserLabelOfflineDisplayed() && isLoginButtonDisplayed();
    }

    private void switchToFormDOM() {
        super.waitForVisibility(loginIframe);
        super.getDriver().switchTo().frame(loginIframe);
    }

    public LoginIFrame triggerForClickOnLoginButton() {

        if (isUserDisconnected()) {
            super.clickElement(loginButton);
            switchToFormDOM();
            return new LoginIFrame(super.getDriver());
        }

        return null;
    }

    public String getUsernameLogged() {

        if (isUserLabelOnlineDisplayed()) {
            return userLabelOnline.getText();
        }

        return "";
    }

    public void goFromUserOptionsToBasePage() {
        super.clickUserButton();
    }

    public void triggerForClickOnLogoutButton() {
        if (isLogoutButtonDisplayed()) {
            super.clickElement(logoutButton);
        }
    }
}
