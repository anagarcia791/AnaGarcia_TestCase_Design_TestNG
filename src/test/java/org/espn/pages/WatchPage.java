package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage {
    @FindBy(css = ".BucketsContainer > div")
    private List<WebElement> carouselsContainer;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul > li")
    private List<WebElement> carouselCards;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul > li:nth-child(2)")
    private WebElement carouselSecondCard;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    private boolean isCarouselsContainerDisplayed() {
        super.waitForVisibility(carouselsContainer);
        return carouselsContainer.size() > 0;
    }

    private boolean areCarouselCardsDisplayed() {
        super.waitForVisibility(carouselCards);
        return carouselCards.size() > 0;
    }

    private boolean isCarouselSecondCardsDisplayed() {
        super.waitForVisibility(carouselSecondCard);
        return carouselSecondCard.isDisplayed();
    }

    public boolean areWatchPageElementsDisplayed() {
        return isCarouselsContainerDisplayed() &&
                areCarouselCardsDisplayed() &&
                isCarouselSecondCardsDisplayed();
    }

    public void clickOnCarouselSecondCard() {
        super.clickElement(carouselSecondCard);
    }
}
