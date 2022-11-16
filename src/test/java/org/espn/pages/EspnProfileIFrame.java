package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EspnProfileIFrame extends WebOperations {
    @FindBy(css = "#Title > span")
    private WebElement userUpdateAccountLabel;

    @FindBy(css = "#AccountDeleteLink")
    private WebElement deleteLink;

    public EspnProfileIFrame(WebDriver driver) {
        super(driver);
    }

    public AccountDeleteIFrame triggerClickOnDeleteLink() {
        isElementDisplayed(userUpdateAccountLabel);
        super.clickElement(deleteLink);
        return new AccountDeleteIFrame(super.getDriver());
    }
}
