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

    public void clickConfirmSingUpButton(String name, String lastName, String email, String password) {
        super.typeOnInput(nameInputSingUpForm, name);
        super.typeOnInput(lastNameInputSingUpForm, lastName);
        super.typeOnInput(emailInputSingUpForm, email);
        super.typeOnInput(passwordInputSingUpForm, password);
        super.clickElement(singUpButtonSubmitForm);
    }
}
