package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#text-input-what")
    private WebElement SearchBar;

    @FindBy(css = "button[type='submit']")
    private WebElement SearchButton;

    public void enterSearchKeyword(){
        SearchBar.click();
        SearchBar.sendKeys("tester");
    }

    public void clickSearch(){
        SearchButton.click();
    }
}
