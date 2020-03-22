import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HomePage {

    WebDriver driver;
    By button = By.xpath("//*[contains(@class,'NKcBbd')]");
    String homepage = "homepage 'start' button";
    final static public Integer defaultTimeout = 10;
    protected long defaultWaitIntervals = 3;
    public Boolean markElementByDefault = true;

    By buttonToStart = By.xpath("//button[text()='Start']");

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
        WebElement wb1 =wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        if (!wb1.isDisplayed()) {
            System.out.println("Not finished loading");
        }

        return wb1.getText();
    }


    public void navigate(String url) {
        driver.navigate().to(url);
    }

    public void clickOnButton() {
        try {
            System.out.println("Trying to find button");
            if (isDisplayed(buttonToStart, 3)) {
                clickOnItem(buttonToStart);
            }
        } catch (Exception e) {
            System.out.println(String.format("Unable to find button %s",buttonToStart));
        }
    }

    public void clickOnItem(By locator) {
        System.out.println(String.format("Trying to click on %s",locator));
        driver.findElement(locator).click();
        System.out.println(String.format("Clicked on %s",locator));
    }


    public void highlightElement(By locator) {
        WebElement elem = driver.findElement(locator);
        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        }
    }


    public Boolean isDisplayed(By locator, Integer... optionalTimeout) {
        Integer timeout = defaultTimeout;
        if (optionalTimeout != null) {
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
                highlightElement(locator);
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
