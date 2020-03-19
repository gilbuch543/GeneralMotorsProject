import org.junit.*;

public class MainPageTests extends BaseTestBase {


    private HomePageLogics homePageLogics;
    private String targetUrl = "https://www.ynet.co.il/home/0,7340,L-8,00.html";
    @Before
    public void setUp() {
        homePageLogics = new HomePageLogics(driver);

    }

    /*@After
    public static void TearDown() {
        TearDown();
    }*/

    @Test
     public void navigateToYnet() {
        System.out.println("### Running test: " );
        /**
         * Navigate and check Categories from different links and location on Marketplace Home page and Categories page
         *
         * Steps:
         * navigate to page by given url
         *
         */

        homePageLogics.navigateToUrl(targetUrl);
    }
}
