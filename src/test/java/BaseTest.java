import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.config.ConfigFile;
import org.example.config.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static ExtentReports extent;
    public static ExtentTest test;
    WebDriver driver;
    @BeforeTest
    public void initializeConfig(){
        ConfigFile.INSTANCE.init();
    }

    @BeforeSuite
    public void initializeReport(){
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
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
    public void tearDownDriver(){
        driver.quit();
    }
    @AfterTest
    public void tearDownReport(){
        extent.flush();
    }
}
