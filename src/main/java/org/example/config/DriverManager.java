package org.example.config;

import org.example.exceptions.SetupException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum DriverManager {

    INSTANCE;
    public WebDriver initDefault(){
        switch (ConfigFile.Browser){
            case "chrome":
                return new ChromeDriver();

            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                return new FirefoxDriver(options);

            default:
                throw new SetupException(ConfigFile.Browser + " Browser is not supported");
        }
    }

    public WebDriver initCrossBrowser(String browser){
        switch (browser){
            case "chrome":
                return new ChromeDriver();

            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                return new FirefoxDriver(options);

            default:
                throw new SetupException(ConfigFile.Browser + " Browser is not supported");
        }
    }
}
