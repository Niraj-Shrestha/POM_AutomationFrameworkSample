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

    @Parameters({"browsers"})
    @BeforeTest
    public void initializeDriver(@Optional String browserList){
        if(browserList == null){
            driver = DriverManager.INSTANCE.initDefault();
        }else {
            String[] browsers = browserList.split(",");
            for (String browser : browsers) {
                driver = DriverManager.INSTANCE.initCrossBrowser(browser);
            }
        }
        driver.get(ConfigFile.BaseURL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
