import org.example.config.ConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void initializeConfig(){
        ConfigFile.INSTANCE.init();
    }

    @BeforeTest
    public void initializeDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.get(ConfigFile.BaseURL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
