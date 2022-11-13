package org.espn.pages;

import org.espn.configuration.WebOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {

    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isEspnLogoDisplayed(){
        return espnLogo.isDisplayed();
    }

    public boolean isUserButtonDisplayed(){
        return userButton.isDisplayed();
    }

    public HomePage actionForClickUserButton(){
        super.waitForVisibility(espnLogo);
        super.waitForVisibility(userButton);

        if(isEspnLogoDisplayed() && isUserButtonDisplayed()){
            super.clickElement(userButton);
            return new HomePage(super.getDriver());
        }

        return null;
    }
}
