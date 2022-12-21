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

    public UserOptionsIFrame goToUserOptions() {
        isElementDisplayed(espnLogo);
        clickElement(userButton);
        return new UserOptionsIFrame(getDriver());
    }

    public WatchPage goToWatchPage() {
        clickElement(watchLink);
        return new WatchPage(getDriver());
    }
}
