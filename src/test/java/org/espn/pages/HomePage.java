package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(css = ".display-user")
    private WebElement userLabelOffline;

    @FindBy(css = ".display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "ul.account-management li:nth-child(7)")
    private WebElement loginButton;

    @FindBy (id = "oneid-iframe")
    private WebElement loginIframe;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private boolean isUserLabelOfflineDisplayed(){
        return userLabelOffline.isDisplayed();
    }

    private boolean isUserLabelOnlineDisplayed(){
        return userLabelOnline.isDisplayed();
    }

    private boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }

    private void switchToFormDOM(){
        super.waitForVisibility(loginIframe);
        super.getDriver().switchTo().frame(loginIframe);
    }

    public LoginPage actionForClickLoginButton(){
        super.waitForVisibility(userLabelOffline);
        super.waitForVisibility(loginButton);

        if(isUserLabelOfflineDisplayed() && isLoginButtonDisplayed()){
            super.clickElement(loginButton);
            switchToFormDOM();
            return new LoginPage(super.getDriver());
        }

        return null;
    }

    public String getUsernameLogged(){
        super.waitForVisibility(userLabelOnline);

        if(isUserLabelOnlineDisplayed()){
            return userLabelOnline.getText();
        }

        return "";
    }
}
