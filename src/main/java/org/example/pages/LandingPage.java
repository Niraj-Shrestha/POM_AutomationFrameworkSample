package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "text-input-what")
    protected WebElement SearchBar;

    @FindBy(xpath = "//button[text()='Search']")
    protected WebElement SearchButton;

    public void enterSearchKeyword(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.visibilityOf(SearchBar));
        SearchBar.click();
        System.out.println("searchbar clicked");
        SearchBar.sendKeys("tester");
        System.out.println("entered data");
    }

    public void clickSearch(){
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driverWait.until(ExpectedConditions.visibilityOf(SearchButton));
        SearchButton.click();
        System.out.println("searchbutton clicked");
    }
}
