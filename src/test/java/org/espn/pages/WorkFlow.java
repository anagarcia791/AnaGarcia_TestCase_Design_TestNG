package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;

public class WorkFlow extends WebOperations {
    public WorkFlow(WebDriver driver) {
        super(driver);
    }

    public void loginAction(MainNavBar mainNavBar, String email, String password) {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        LoginIFrame loginIFrame = userOptionsIFrame.clickLoginButton();
        loginIFrame.clickConfirmLoginButton(email, password);
    }

    public void logoutAction(MainNavBar mainNavBar) {
        UserOptionsIFrame userOptionsIFrame = mainNavBar.goToUserOptions();
        userOptionsIFrame.clickLogoutButton();
    }
}
