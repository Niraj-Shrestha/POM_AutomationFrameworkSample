import org.example.config.ConfigFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    @BeforeTest
    public void initializeDriver(){
        driver = new ChromeDriver();
        driver.get(ConfigFile.BaseURL);
    }

    @BeforeTest
    public void initializeConfig(){
        ConfigFile.INSTANCE.init();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
