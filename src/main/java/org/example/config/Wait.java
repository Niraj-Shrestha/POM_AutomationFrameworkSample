package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface Wait {
    default void waitUntilElementIsVisible(WebDriver driver, WebElement element){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    default void waitUntilTitleIs(WebDriver driver, String element){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.titleIs(element));
    }

    default void waitUntilElementIsClickable(WebDriver driver, WebElement element){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    default void waitUntilAlertIsPresent(WebDriver driver){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.alertIsPresent());
    }
}
