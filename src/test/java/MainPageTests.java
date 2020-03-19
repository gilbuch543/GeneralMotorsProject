import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class MainPageTests extends BaseFrontEnd {


    //private HomePageLogics homePageLogics;
    private String targetUrl = "https://www.ynet.co.il/home/0,7340,L-8,00.html";
    public HomePage homePage;

    public String HELLOWORLD = "Hello World!";
    public String HEYWORLD = "Hey World!";
    public String URL = "https://www.google.co.il";

    @BeforeTest
    public void initialize()  {
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
        homePage.clickOnCoronaNews();

       // boolean isClicked = homePage.clickOnButton();
       // assertTrue(isClicked, "Expected - button clicked; Actual - Failed");
       // homePage.navigateToHomePage();

       // boolean isClicked = homePage.clickOnButton();
      //  assertTrue(isClicked, "Expected - button clicked; Actual - Failed");
        //String results = homePage.WaitForResults();
       // assertTrue(results.matches(HELLOWORLD), "Expected - result after click is" + HELLOWORLD + "; Actual - NOT");
    }

    @Test
    public void TestVerifyWrongResult() throws InterruptedException {
        // HomePage homePage = PageFactory.initElements(driver, HomePage.class);


      //  boolean isClicked = homePage.clickOnButton();
      //  assertTrue(isClicked, "Expected - button clicked; Actual - Failed");
        String results = homePage.WaitForResults();
        homePage.highlightElement();
        boolean finalResult = results.matches(HEYWORLD);
        if (!finalResult) {
            printWrongValidationMessage();
        }
        assertTrue(finalResult, "Expected - results after clicking " + HELLOWORLD + "; Actual - " + HEYWORLD);

        //  assertTrue(results.matches(HEYWORLD), "Expected - result after click is" + HEYWORLD);
    }

    private void printWrongValidationMessage() {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("D:/error.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
   /* public WebElement fluentWait(final By locator){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return  foo;
    };*/
}
