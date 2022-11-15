package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EspnProfileIFrame extends UserOptionsIFrame {
    @FindBy(css = "#Title > span")
    private WebElement userUpdateAccountLabel;

    @FindBy(css = "form.form-section.update-profile > #AccountDeleteLink")
    private WebElement deleteLink;

    public EspnProfileIFrame(WebDriver driver) {
        super(driver);
    }

    private boolean isUserUpdateAccountLabelDisplayed() {
        super.waitForVisibility(userUpdateAccountLabel);
        return userUpdateAccountLabel.isDisplayed();
    }

    private boolean isDeleteLinkDisplayed() {
        super.waitForVisibility(deleteLink);
        return deleteLink.isDisplayed();
    }

    public AccountDeleteIFrame triggerClickOnDeleteLink() {

        if (isUserUpdateAccountLabelDisplayed() && isDeleteLinkDisplayed()) {
            super.clickElement(deleteLink);
            return new AccountDeleteIFrame(super.getDriver());
        }

        return null;
    }
}
