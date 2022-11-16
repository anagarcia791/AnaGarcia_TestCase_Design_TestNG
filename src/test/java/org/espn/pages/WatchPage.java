package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends WebOperations {
    @FindBy(css = "section.Carousel")
    private List<WebElement> carouselsContainer;

    @FindBy(css = "section[aria-labelledby^='bucket-40'] li")
    private List<WebElement> carouselCards;

    @FindBy(css = ".lightbox__closebtn")
    private WebElement exitFromChooseSupplierBtn;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    private boolean isCarouselsContainerDisplayed() {
        isElementDisplayed(carouselsContainer.get(0));
        return carouselsContainer.size() > 0;
    }

    private boolean areCarouselCardsDisplayed() {
        isElementDisplayed(carouselCards.get(0));
        return carouselCards.size() > 0;
    }

    public Boolean isExitFromChooseSupplierBtnDisplayed() {
        return isElementDisplayed(exitFromChooseSupplierBtn);
    }

    public boolean areWatchPageElementsDisplayed() {
        return isCarouselsContainerDisplayed() && areCarouselCardsDisplayed();
    }

    public void clickOnCarouselSecondCard() {
        super.clickElement(carouselCards.get(1));
    }

    public void clickOnExitFromChooseSupplier() {
        super.clickElement(exitFromChooseSupplierBtn);
    }

    public void goToBasePage() {
        super.goToPreviousPage();
    }
}
