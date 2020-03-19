import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseFrontEnd {

    public static WebDriver driver = null;
    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
//To maximize browser
        driver.manage().window().maximize();
//Implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//To open testPage
      //  driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

    }
    @AfterSuite
//Test cleanup
    public void TeardownTest()
    {
        BaseFrontEnd.driver.quit();
    }

}
