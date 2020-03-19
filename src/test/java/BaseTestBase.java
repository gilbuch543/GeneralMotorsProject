import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BaseTestBase {
    protected static WebDriver driver;

    public  BaseTestBase() {}
    public  BaseTestBase(WebDriver driver) {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            this.driver = driver;
            PageFactory.initElements(driver,this);
//To maximize browser
            driver.manage().window().maximize();
//Implicit wait
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//To open testPage
            //driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        }
        catch(Exception e){
            System.err.println("Couldnt initiate driver , Please try again");
        }
    }

    public void TestBase() {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
//To maximize browser
            driver.manage().window().maximize();
//Implicit wait
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//To open testPage
            driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        }
        catch(Exception e){
            System.err.println("Couldnt initiate driver , Please try again");
            }
    }

  //  public BaseTestBase(WebDriver driver){
   //     this.driver = driver;
    //}
    @AfterClass
//Test cleanup
    public static void TearDown()
    {
        BaseTestBase.driver.quit();
    }
}
