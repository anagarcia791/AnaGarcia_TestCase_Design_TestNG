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

    private void switchToFormDOM() {
        super.waitForVisibility(loginIframe);
        super.getDriver().switchTo().frame(loginIframe);
    }

    public LoginIFrame actionForClickLoginButton() {

        if (isUserLabelOfflineDisplayed() && isLoginButtonDisplayed()) {
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
        super.reloadPage();
    }
}
