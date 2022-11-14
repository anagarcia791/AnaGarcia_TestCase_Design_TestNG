package org.espn.pages;

import org.espn.configuration.WebOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations {
    @FindBy(css = ".container h1")
    private WebElement espnLogo;

    @FindBy(css = ".espn-en > li.pillar.watch > a > span > span.link-text")
    private WebElement watchLink;

    @FindBy(id = "global-user-trigger")
    private WebElement userButton;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    private boolean isEspnLogoDisplayed() {
        super.waitForVisibility(espnLogo);
        return espnLogo.isDisplayed();
    }

    private boolean isWatchLinkDisplayed() {
        super.waitForVisibility(watchLink);
        return watchLink.isDisplayed();
    }

    private boolean isUserButtonDisplayed() {
        super.waitForVisibility(userButton);
        return userButton.isDisplayed();
    }

    public void clickUserButton() {
        super.clickElement(userButton);
    }

    public UserOptionsIFrame goToUserOptions() {
        if (isEspnLogoDisplayed() && isUserButtonDisplayed()) {
            clickUserButton();
            return new UserOptionsIFrame(super.getDriver());
        }

        return null;
    }

    public WatchPage goToWatchPage() {
        if (isWatchLinkDisplayed()) {
            super.clickElement(watchLink);
            return new WatchPage(super.getDriver());
        }

        return null;
    }
}
