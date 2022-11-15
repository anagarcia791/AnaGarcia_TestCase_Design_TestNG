package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginIFrame extends UserOptionsIFrame {
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

    private boolean isEspnLogoFormDisplayed() {
        super.waitForVisibility(espnLogoForm);
        return espnLogoForm.isDisplayed();
    }

    private boolean isEmailInputFormDisplayed() {
        super.waitForVisibility(emailInputForm);
        return emailInputForm.isDisplayed();
    }

    private boolean isPasswordInputFormDisplayed() {
        super.waitForVisibility(passwordInputForm);
        return passwordInputForm.isDisplayed();
    }

    private boolean isLoginButtonSubmitFormDisplayed() {
        super.waitForVisibility(loginButtonSubmitForm);
        return loginButtonSubmitForm.isDisplayed();
    }

    private boolean isSignUpButtonSubmitFormDisplayed() {
        super.waitForVisibility(signUpButtonSubmitForm);
        return signUpButtonSubmitForm.isDisplayed();
    }

    private boolean isAccountDeactivatedSpanDisplayed() {
        super.waitForVisibility(accountDeactivatedSpan);
        return accountDeactivatedSpan.isDisplayed();
    }

    private boolean isEmailAccountDeactivatedDisplayed() {
        super.waitForVisibility(emailAccountDeactivated);
        return emailAccountDeactivated.isDisplayed();
    }

    public boolean areLoginFormElementsDisplayed() {
        return isEspnLogoFormDisplayed() &&
                isEmailInputFormDisplayed() &&
                isPasswordInputFormDisplayed() &&
                isLoginButtonSubmitFormDisplayed() &&
                isSignUpButtonSubmitFormDisplayed();
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
        if (isAccountDeactivatedSpanDisplayed() &&
                isEmailAccountDeactivatedDisplayed()
        ) {
            System.out.println(emailAccountDeactivated.getText());
            return emailAccountDeactivated.getText();
        }

        return "";
    }
}
