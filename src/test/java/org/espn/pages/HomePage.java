package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement userLabelOffline;

    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user span")
    private WebElement userLabelOnline;

    @FindBy(css = "div.global-user:last-child ul.account-management li:nth-child(7)")
    private WebElement loginButton;

    @FindBy (id = ".loading-container > .view-starry-night  > div > .form-section")
    private WebElement loginIframe;

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

    private WebDriver changeToFormsDriver(){
        super.waitForVisibility(loginIframe);
        super.getDriver().switchTo().frame(loginIframe);
        return super.getDriver();
    }

    public LoginPage actionForClickLoginButton(){
        super.waitForVisibility(userLabelOffline);
        super.waitForVisibility(loginButton);

        if(isUserLabelOfflineDisplayed() && isLoginButtonDisplayed()){
            System.out.println(super.getDriver() + "ANTES");
            super.clickElement(loginButton);
            WebDriver iFrameDriver = changeToFormsDriver();
            System.out.println(iFrameDriver + "DESPUES");
            return new LoginPage(iFrameDriver);
        }

        return null;
    }

    public String getUsernameLogged(){
        if(isUserLabelOnlineDisplayed()){
            return userLabelOnline.getText();
        }
        return "";
    }
}
