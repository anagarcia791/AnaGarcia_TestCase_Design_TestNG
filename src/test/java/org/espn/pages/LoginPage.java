package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage{
    @FindBy(id= "InputLoginValue")
    private WebElement emailInputForm;

    @FindBy (id= "InputPassword")
    private WebElement passwordInputForm;

    @FindBy (id= "BtnSubmit")
    private WebElement loginButtonSubmitForm;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButtonSubmitForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private boolean isEmailInputFormDisplayed(){
        return emailInputForm.isDisplayed();
    }

    private boolean isPasswordInputFormDisplayed(){
        return passwordInputForm.isDisplayed();
    }

    private boolean isLoginButtonSubmitFormDisplayed(){
        return loginButtonSubmitForm.isDisplayed();
    }

    private boolean isSignUpButtonSubmitFormDisplayed(){
        return signUpButtonSubmitForm.isDisplayed();
    }

    public void triggerUserLogging(String email, String password){
        super.waitForVisibility(emailInputForm);
        super.waitForVisibility(passwordInputForm);
        super.waitForVisibility(loginButtonSubmitForm);
        super.waitForVisibility(signUpButtonSubmitForm);

        if(isEmailInputFormDisplayed() &&
                isPasswordInputFormDisplayed() &&
                isLoginButtonSubmitFormDisplayed() &&
                isSignUpButtonSubmitFormDisplayed()
        ){
            super.typeOnInput(emailInputForm, email);
            super.typeOnInput(passwordInputForm, password);
            super.clickElement(loginButtonSubmitForm);
        }
    }
}
