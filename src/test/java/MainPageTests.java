import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class MainPageTests extends BaseFrontEnd {


    //private HomePageLogics homePageLogics;
    public HomePage homePage;

    public String HELLOWORLD = "Hello World!";
    public String HEYWORLD = "Hey World!";
    private String URL = "http://the-internet.herokuapp.com/dynamic_loading/2";


    @BeforeTest
    public void initialize() {
        super.initialize();
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterTest
//Test cleanup
    public void TeardownTest() {
        super.TeardownTest();
    }

    @Test
    public void TestVerifyButtonClickResult() {
        //HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        //  scenario
        homePage.navigate(URL);
        homePage.clickOnButton();
        homePage.WaitForResults();
        // boolean isClicked = homePage.clickOnButton();
        // assertTrue(isClicked, "Expected - button clicked; Actual - Failed");
        // homePage.navigateToHomePage();

        // boolean isClicked = homePage.clickOnButton();
        //  assertTrue(isClicked, "Expected - button clicked; Actual - Failed");
        //String results = homePage.WaitForResults();
        // assertTrue(results.matches(HELLOWORLD), "Expected - result after click is" + HELLOWORLD + "; Actual - NOT");
    }

    @Test
    public void TestVerifyWrongResult() {
        homePage.navigate(URL);
        homePage.clickOnButton();
        String results = homePage.WaitForResults();
        Boolean testResults = results.equals(HEYWORLD);
        if (!testResults) {
            TestUtils.getScreenshot();
        }
        Assert.assertTrue((testResults), "Expected - results after clicking " + HELLOWORLD + "; Actual - " + HEYWORLD);

    }

}
