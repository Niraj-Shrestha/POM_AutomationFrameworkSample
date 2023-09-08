import org.example.config.ConfigFile;
import org.example.config.DriverManager;
import org.example.exceptions.SetupException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    WebDriver driver;
    @BeforeTest
    public void initializeConfig(){
        ConfigFile.INSTANCE.init();
    }

    @Parameters({"browser"})
    @BeforeTest
    public void initializeDriver(@Optional String browser){
        if(browser == null){
            driver = DriverManager.INSTANCE.init();
        }else {
            driver = DriverManager.INSTANCE.initCrossBrowser(browser);
        }
        driver.get(ConfigFile.BaseURL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
