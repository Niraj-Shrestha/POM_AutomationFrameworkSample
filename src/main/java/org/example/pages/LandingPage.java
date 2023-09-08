package org.example.pages;

import org.example.config.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage extends BasePage implements Wait{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "text-input-what")
    protected WebElement SearchBar;

    @FindBy(xpath = "//button[text()='Search']")
    protected WebElement SearchButton;

    public void enterSearchKeyword(){
        waitUntilElementIsVisible(driver,SearchBar);
        SearchBar.click();
        System.out.println("searchbar clicked");
        SearchBar.sendKeys("tester");
        System.out.println("entered data");
    }

    public void clickSearch(){
        waitUntilElementIsVisible(driver,SearchButton);
        SearchButton.click();
        System.out.println("searchbutton clicked");
    }
}
