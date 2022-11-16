package org.espn.pages;

import org.espn.configuration.WebOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainNavBar extends WebOperations {
    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(css = ".pillar.watch")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    public MainNavBar(WebDriver driver) {
        super(driver);
    }

    public void clickUserButton() {
        super.clickElement(userButton);
    }

    public UserOptionsIFrame goToUserOptions() {
        isElementDisplayed(espnLogo);
        clickUserButton();
        return new UserOptionsIFrame(super.getDriver());
    }

    public WatchPage goToWatchPage() {
        super.clickElement(watchLink);
        return new WatchPage(super.getDriver());
    }
}
