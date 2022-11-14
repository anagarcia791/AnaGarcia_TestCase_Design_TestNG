package org.espn.tests;

import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class WatchPageTest extends BaseTest{
    @Test(priority = 2)
    public void navigationToWatchPage() {
        WatchPage watchPage = super.basePage.goToWatchPage();
        checkThat("more than one carousel is present", watchPage.areWatchPageElementsDisplayed()
                , is(true));
        watchPage.clickOnCarouselSecondCard();
    }
}
