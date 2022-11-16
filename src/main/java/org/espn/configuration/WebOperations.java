package org.espn.configuration;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriverWait getWait(Integer intWait) {
        return new WebDriverWait(driver, Duration.ofSeconds(intWait));
    }

    public Boolean isElementDisplayed(WebElement element, Integer intWait) {
        try {
            getWait(intWait).until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void typeOnInput(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void goToPreviousPage() {
        driver.navigate().back();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}
