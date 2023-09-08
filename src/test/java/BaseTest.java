import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    @BeforeTest
    public void initializeDriver(){
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.get("https://www.indeed.com/");
    }

    /*@BeforeTest
    public void initializeConfig(){
        ConfigFile.INSTANCE.init();
    }*/

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
