import org.example.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    private LandingPage landingPage;
    @BeforeMethod
    public void before(){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }
    @Test
    public void test() throws InterruptedException {
        landingPage.enterSearchKeyword();
        landingPage.clickSearch();
    }
}
