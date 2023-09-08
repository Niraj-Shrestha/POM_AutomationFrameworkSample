package org.example.pages;

import org.example.config.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        SearchBar.sendKeys("tester");
    }

    public void clickSearch(){
        waitUntilElementIsVisible(driver,SearchButton);
        SearchButton.click();
    }
}
