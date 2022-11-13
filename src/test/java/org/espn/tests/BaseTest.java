package org.espn.tests;

import org.testng.annotations.*;

import org.espn.configuration.Driver;
import org.espn.pages.BasePage;

import org.espn.reporting.Reporter;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import static java.lang.String.format;

public class BaseTest {
    private Driver driver;
    protected BasePage basePage;

    @DataProvider(name = "usersLoginData-provider")
    public Object[][] getUsersLoginData() {
        return new Object[][]{{"am.garcia@globant.com", "espnTEST123"}};
    }

    //   @Parameters({"browser", "url"}) String browser, String url
    @BeforeSuite
    public void initialSetUp() {
        String BROWSER = "chrome";
        String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";

        driver = new Driver(BROWSER);
        Reporter.info("Deleting cookies");
        driver.getDriver().manage().deleteAllCookies();
        Reporter.info("Navigating to: " + URL);
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        this.basePage = new BasePage(driver.getDriver());
    }

    @AfterSuite
    public void tearDown() {
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
