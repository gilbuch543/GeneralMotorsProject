import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{

    WebDriver driver;
    //img[contains(@src, 'default/x-gray.svg')src="/images/CENTRAL_1024_ynet_logo.png"
    By button = By.xpath("//*[contains(@class,'NKcBbd')]");
    String homepage = "homepage";
    final static public Integer defaultTimeout =10;
    protected long defaultWaitIntervals = 2;
    final static public Integer markElementInMS = 100;
    final static public Integer sleepBetweenMarkAndUnmarkInMS =10;
    public Boolean markElementByDefault = true;
    WebElement clickResult;
   ;



  /*  @FindBy(
            how = How.XPATH,
            using = "//*[@data-ved='0ahUKEwj5uuS09qboAhUKzhoKHT9pB-gQ4dUDCAo']"
    )
    WebElement button;
    @FindBy(
            how = How.XPATH,
            using = "//*[@id=\"finish\"]/h4"
    )
    WebElement clickResult;*/

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 /*   public boolean clickOnButton() {
        String currentLocator = this.button.toString();

        try {
            if (!this.button.isDisplayed()) {
                System.out.println("Element Not Visible");
                return false;
            } else if (!this.button.isEnabled()) {
                System.out.println("Element Disable");
                return false;
            } else {
                this.button.click();
                System.out.println("clicked " + currentLocator);
                return true;
            }
        } catch (Exception var3) {
            System.out.println(var3.getCause());
            return false;
        }
    }*/

    public String WaitForResults() {
        WebDriverWait wait = new WebDriverWait(this.driver, 5L);
        WebElement wb1 = (WebElement)wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        if (!wb1.isDisplayed()) {
            System.out.println("NOT");
        }

        return wb1.getText();
    }



    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public void clickOnCoronaNews() {
        try {
            if (isDisplayed(button, 5)) {
                System.out.println(String.format("Trying to click on %s", homepage));
                clickOnItem(button);
            }
        } catch(Exception e){
            System.out.println(String.format("Unable to find button %s"));
        }
    }

    public void clickOnItem(By locator) {
        driver.findElement(locator).click();
        //click(locator,true);
    }


    public void highlightElement()  {
        WebElement elem = driver.findElement(button);
        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        }
    }


    public Boolean isDisplayed(By locator , Integer... optionalTimeout) {
        Integer timeout = defaultTimeout;
        if (optionalTimeout != null){
            timeout = (optionalTimeout.length > 0) ? optionalTimeout[0] : defaultTimeout;
        }
        return waitForElementVisibility(locator, timeout);
    }

    public Boolean waitForElementVisibility(By locator, Integer... timeout) {
        return this.waitForElementVisibility(locator, markElementByDefault, timeout);
    }
    public Boolean waitForElementVisibility(By locator, Boolean activateMarkElement, Integer... timeout) {
        try {
            WebElement element = waitGenerator(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (element == null) {
                return false;
            }
            if (activateMarkElement) {
                highlightElement();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private WebDriverWait waitGenerator(Integer... timeout) {
        return new WebDriverWait(driver, (timeout.length > 0) ? timeout[0] : defaultTimeout, defaultWaitIntervals);
    }
}
