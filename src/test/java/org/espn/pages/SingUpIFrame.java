package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SingUpIFrame extends WebOperations {

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

    public void fillSingUpInputs(String name, String lastName, String email, String password) {
        typeOnInput(nameInputSingUpForm, name);
        typeOnInput(lastNameInputSingUpForm, lastName);
        typeOnInput(emailInputSingUpForm, email);
        typeOnInput(passwordInputSingUpForm, password);
    }

    public void clickConfirmSingUpButton() {
        isElementDisplayed(singUpButtonSubmitForm);
        clickElement(singUpButtonSubmitForm);
    }
}
