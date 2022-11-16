package org.espn.tests;

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

    @DataProvider(name = "userLoginData-provider")
    public Object[][] getUserLoginData() {
        return new Object[][]{{"am.garcia@globant.com", "TESTespn345"}};
    }

    @BeforeClass
    public void initialSetUp() {
        String BROWSER = "chrome";
        String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

        driver = new Driver(BROWSER);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + URL);
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        this.mainNavBar = new MainNavBar(driver.getDriver());
    }

    @AfterClass
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
