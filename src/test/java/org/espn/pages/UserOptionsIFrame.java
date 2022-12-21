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

    @FindBy(css = "a[tref$='modifyAccount']")
    private WebElement espnProfileButton;

    @FindBy(css = "a[onclick*='logout']")
    private WebElement logoutButton;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(id = "oneid-iframe")
    private WebElement espnProfileIframe;

    public UserOptionsIFrame(WebDriver driver) {
        super(driver);
    }

    public boolean isUserDisconnected() {
        return isElementDisplayed(userLabelOffline) && isElementDisplayed(loginButton);
    }

    private void switchToLoginIFrameDOM() {
        isElementDisplayed(loginIframe);
        getDriver().switchTo().frame(loginIframe);
    }

    public LoginIFrame clickLoginButton() {
        clickElement(loginButton);
        switchToLoginIFrameDOM();
        return new LoginIFrame(getDriver());
    }

    public String getUsernameLogged() {
        if (isElementDisplayed(userLabelOnline)) {
            return userLabelOnline.getText();
        }
        return "";
    }

    private void switchToEspnProfileIframeIframeDOM() {
        isElementDisplayed(espnProfileIframe);
        getDriver().switchTo().frame(espnProfileIframe);
    }

    public EspnProfileIFrame clickEspnProfileButton() {
        clickElement(espnProfileButton);
        switchToEspnProfileIframeIframeDOM();
        return new EspnProfileIFrame(getDriver());
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }
}
