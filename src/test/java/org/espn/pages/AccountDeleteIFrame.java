package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeleteIFrame extends EspnProfileIFrame {

    @FindBy(css = "#Title > span")
    private WebElement areYouSureLabel;

    @FindBy(css = ".form-section > #BtnSubmit")
    private WebElement deletingConfirmButton;

    @FindBy(css = ".form-section > #BtnCancel")
    private WebElement keepAccountButton;

    @FindBy(id = "oneid-iframe")
    private WebElement deletedAccountOkIFrame;

    @FindBy(css = ".form-section > #BtnSubmit")
    private WebElement deletedAccountOkButton;

    public AccountDeleteIFrame(WebDriver driver) {
        super(driver);
    }

    private boolean isAreYouSureSpanDisplayed() {
        super.waitForVisibility(areYouSureLabel);
        return areYouSureLabel.isDisplayed();
    }

    private boolean isDeletingConfirmButtonDisplayed() {
        super.waitForVisibility(deletingConfirmButton);
        return deletingConfirmButton.isDisplayed();
    }

    private boolean isKeepAccountButtonDisplayed() {
        super.waitForVisibility(keepAccountButton);
        return keepAccountButton.isDisplayed();
    }

    private boolean isDeletedAccountOkIFrameDisplayed() {
        super.waitForVisibility(deletedAccountOkIFrame);
        return deletedAccountOkIFrame.isDisplayed();
    }

    private boolean isDeletedAccountOkButtonDisplayed() {
        super.waitForVisibility(deletedAccountOkButton);
        return deletedAccountOkButton.isDisplayed();
    }

    public String getTitleOfAreYouSureIframe() {
        if (isAreYouSureSpanDisplayed() &&
                isDeletingConfirmButtonDisplayed() &&
                isKeepAccountButtonDisplayed()) {
            return areYouSureLabel.getText();
        }
        return "";
    }

    public void triggerClickOnDeletingConfirmButton() {
        super.clickElement(deletingConfirmButton);
    }

    public void switchToDeletedAccountOkIFrameDOM() {
        if (isDeletedAccountOkIFrameDisplayed()) {
            super.getDriver().switchTo().frame(deletedAccountOkIFrame);
        }
    }

    public void triggerClickOnDeletedAccountOkButton() {

        if (isDeletedAccountOkButtonDisplayed()) {
            super.clickElement(deletedAccountOkButton);
        }
    }
}
