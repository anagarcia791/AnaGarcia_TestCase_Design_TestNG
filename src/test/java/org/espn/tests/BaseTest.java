package org.espn.tests;

import org.espn.pages.WorkFlow;
import org.testng.annotations.*;

import org.espn.configuration.Driver;
import org.espn.pages.MainNavBar;

import org.espn.reporting.Reporter;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;

public class BaseTest {
    private Driver driver;
    protected MainNavBar mainNavBar;
    protected WorkFlow workFlow;

    @DataProvider(name = "userLoginData-provider")
    public Object[][] getUserLoginData() {
        return new Object[][]{{"am.garcia@globant.com", "TESTespn345"}};
    }

    @DataProvider(name = "signupData-provider")
    public Object[][] getNewUserData() {
        return new Object[][]{{"test-name", "test-last-name", "test-TO-delete"}};
    }

    @Parameters({"url", "browser"})
    @BeforeTest
    public void initialSetUp(@Optional String url, @Optional String browser) {

        if (url == null && browser == null) {
            browser = "chrome";
            url = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
        }

        driver = new Driver(browser);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + url);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
        this.mainNavBar = new MainNavBar(driver.getDriver());
        this.workFlow = new WorkFlow(driver.getDriver());

        Reporter.info("Closing banner");
        workFlow.checkIfBannerInHomePage();
    }

    @AfterTest
    public void tearDown() {
        Reporter.info("Quitting driver");
        driver.getDriver().quit();
    }

    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Reporter.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            Reporter.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }
}
