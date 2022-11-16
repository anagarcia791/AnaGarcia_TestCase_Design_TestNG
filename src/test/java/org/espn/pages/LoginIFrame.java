package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIFrame extends WebOperations {
    @FindBy(id = "logo")
    private WebElement espnLogoForm;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInputForm;

    @FindBy(id = "InputPassword")
    private WebElement passwordInputForm;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonSubmitForm;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonSubmitForm;

    @FindBy(id = "oneid-iframe")
    private WebElement signUpIframe;

    @FindBy(css = "#Title > span")
    private WebElement accountDeactivatedSpan;

    @FindBy(css = "#TextBlock > strong")
    private WebElement emailAccountDeactivated;

    public LoginIFrame(WebDriver driver) {
        super(driver);
    }

    public boolean areLoginFormElementsDisplayed() {
        return isElementDisplayed(espnLogoForm) &&
                isElementDisplayed(emailInputForm) &&
                isElementDisplayed(passwordInputForm) &&
                isElementDisplayed(loginButtonSubmitForm) &&
                isElementDisplayed(signUpButtonSubmitForm);
    }

    public void triggerUserLogging(String email, String password) {
        super.typeOnInput(emailInputForm, email);
        super.typeOnInput(passwordInputForm, password);
        super.clickElement(loginButtonSubmitForm);
    }

    public SingUpIFrame triggerForClickOnSingUpButton() {
        super.clickElement(signUpButtonSubmitForm);
        return new SingUpIFrame(super.getDriver());
    }

    public String getEmailAccountDeactivated() {
        if (isElementDisplayed(accountDeactivatedSpan) && isElementDisplayed(emailAccountDeactivated)) {
            return emailAccountDeactivated.getText();
        }
        return "";
    }
}
