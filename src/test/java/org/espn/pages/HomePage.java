package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".account-management > .display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".account-management > .display-user > span")
    private WebElement userLabelOnline;

    @FindBy(css = ".account-management > li:nth-child(7)")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLabelOfflineDisplayed(){
        return userLabelOffline.isDisplayed();
    }

    public boolean isUserLabelOnlineDisplayed(){
        return userLabelOnline.isDisplayed();
    }

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }

    public LoginPage actionForClickLoginButton(){
        super.clickElement(loginButton);
        return new LoginPage(super.getDriver());
    }
}
