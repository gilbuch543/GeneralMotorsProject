import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtils extends BaseFrontEnd {


    public static void getScreenshot(){
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("D:/error.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

}
