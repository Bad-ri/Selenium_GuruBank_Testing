package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = String.valueOf(System.currentTimeMillis());
            File destinationFile = new File(System.getProperty("user.dir") +
                    "/src/test/resources/ScreenShots/" + screenshotName + timestamp + ".png");
            FileUtils.copyFile(screenshotFile, destinationFile);
            // "Screenshot saved: " + destinationFile.getAbsolutePath()
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }

}
