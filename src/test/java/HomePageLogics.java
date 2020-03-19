import org.openqa.selenium.WebDriver;

public class HomePageLogics extends BaseTestBase {
    private HomePage homePage;
    public HomePageLogics(WebDriver driver) {
        //super(driver);
        homePage = new HomePage(driver);

    }




    public void navigateToUrl(String url){
    homePage.navigate(url);
    }
}
