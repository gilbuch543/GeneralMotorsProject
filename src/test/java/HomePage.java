import org.openqa.selenium.WebDriver;

public class HomePage extends BaseTestBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigate(String url) {
        driver.navigate().to(url);
    }
}
