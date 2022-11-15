package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingUpIFrame extends LoginIFrame {

    @FindBy(id = "InputFirstName")
    private WebElement nameInputSingUpForm;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputSingUpForm;

    @FindBy(id = "InputEmail")
    private WebElement emailInputSingUpForm;

    @FindBy(id = "password-new")
    private WebElement passwordInputSingUpForm;

    @FindBy(id = "BtnSubmit")
    private WebElement singUpButtonSubmitForm;

    public SingUpIFrame(WebDriver driver) {
        super(driver);
    }

    private boolean isNameInputSingUpFormDisplayed() {
        super.waitForVisibility(nameInputSingUpForm);
        return nameInputSingUpForm.isDisplayed();
    }

    private boolean isLastNameInputSingUpFormDisplayed() {
        super.waitForVisibility(lastNameInputSingUpForm);
        return lastNameInputSingUpForm.isDisplayed();
    }

    private boolean isEmailInputSingUpFormDisplayed() {
        super.waitForVisibility(emailInputSingUpForm);
        return emailInputSingUpForm.isDisplayed();
    }

    private boolean isPasswordInputSingUpFormDisplayed() {
        super.waitForVisibility(passwordInputSingUpForm);
        return passwordInputSingUpForm.isDisplayed();
    }

    private boolean isSingUpButtonSubmitFormDisplayed() {
        super.waitForVisibility(singUpButtonSubmitForm);
        return singUpButtonSubmitForm.isDisplayed();
    }

    private boolean areSingUpElementsDisplayed() {
        return isNameInputSingUpFormDisplayed() &&
                isLastNameInputSingUpFormDisplayed() &&
                isEmailInputSingUpFormDisplayed() &&
                isPasswordInputSingUpFormDisplayed() &&
                isSingUpButtonSubmitFormDisplayed();
    }

    public void triggerUserSingUp(String name, String lastName, String email, String password) {

        if (areSingUpElementsDisplayed()) {
            super.typeOnInput(nameInputSingUpForm, name);
            super.typeOnInput(lastNameInputSingUpForm, lastName);
            super.typeOnInput(emailInputSingUpForm, email);
            super.typeOnInput(passwordInputSingUpForm, password);
        }

        super.clickElement(singUpButtonSubmitForm);
    }
}
