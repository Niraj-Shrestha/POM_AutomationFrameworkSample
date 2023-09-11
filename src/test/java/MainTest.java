import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    private LandingPage landingPage;
    @BeforeMethod
    public void before(){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }
    @Test
    public void test() {
        landingPage.enterSearchKeyword();
        test = extent.createTest("Search Jobs", "Searching Jobs in Indeed");
        test.log(Status.PASS,"Search Keyword");
        landingPage.clickSearch();
        test.log(Status.PASS,"Click Search");
    }
}
