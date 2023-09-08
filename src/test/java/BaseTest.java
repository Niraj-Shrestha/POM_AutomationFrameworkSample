import org.example.config.ConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    @BeforeTest
    public void initializeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless"); // Run Chrome in headless mode
        driver = new ChromeDriver(chromeOptions);
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
