package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserOptionsIFrame extends WebOperations {
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "a[tref$='login']")
    private WebElement loginButton;

    @FindBy(css = "ul.account-management li:nth-child(5)")
    private WebElement espnProfileButton;

    @FindBy(css = "ul.account-management li:nth-child(9)")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "oneid-iframe")
    private WebElement updateAccountIframe;

    public UserOptionsIFrame(WebDriver driver) {
        super(driver);
    }

    public boolean isUserDisconnected() {
        return isElementDisplayed(userLabelOffline) && isElementDisplayed(loginButton);
    }

    private void switchToLoginIFrameDOM() {
        isElementDisplayed(loginIframe);
        super.getDriver().switchTo().frame(loginIframe);
    }

    public LoginIFrame triggerForClickOnLoginButton() {
        super.clickElement(loginButton);
        switchToLoginIFrameDOM();
        return new LoginIFrame(super.getDriver());
    }

    public String getUsernameLogged() {

        if (isElementDisplayed(userLabelOnline)) {
            return userLabelOnline.getText();
        }

        return "";
    }

    private void switchToUpdateAccountIframeDOM() {
        isElementDisplayed(updateAccountIframe);
        super.getDriver().switchTo().frame(updateAccountIframe);
    }

    public EspnProfileIFrame triggerForClickOnEspnProfileButton() {
        super.clickElement(espnProfileButton);
        switchToUpdateAccountIframeDOM();
        return new EspnProfileIFrame(super.getDriver());
    }

    public void triggerForClickOnLogoutButton() {
        super.clickElement(logoutButton);
    }
}
