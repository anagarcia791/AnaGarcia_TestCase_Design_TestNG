package org.espn.configuration;

import java.time.Duration;
import java.util.List;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(List<WebElement> elements) {
        this.wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    public void typeOnInput(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void goToPreviousPage() {
        driver.navigate().back();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}
