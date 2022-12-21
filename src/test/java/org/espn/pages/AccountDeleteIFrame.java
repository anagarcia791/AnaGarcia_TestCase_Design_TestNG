package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeleteIFrame extends WebOperations {

    @FindBy(css = "#Title > span")
    private WebElement areYouSureLabel;

    @FindBy(css = ".form-section > #BtnSubmit")
    private WebElement deletingConfirmButton;

    @FindBy(css = ".form-section > #BtnCancel")
    private WebElement keepAccountButton;

    public AccountDeleteIFrame(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfAreYouSureIframe() {
        if (isElementDisplayed(areYouSureLabel) &&
                isElementDisplayed(deletingConfirmButton) &&
                isElementDisplayed(keepAccountButton)) {
            return areYouSureLabel.getText();
        }
        return "";
    }

    public void clickConfirmDeletingButton() {
        clickElement(deletingConfirmButton);
    }
}
