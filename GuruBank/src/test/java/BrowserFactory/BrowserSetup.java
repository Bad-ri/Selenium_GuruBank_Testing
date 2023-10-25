package BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserSetup {
    public WebDriver driver ;
    public WebDriverWait wait ;
    @BeforeMethod
    public void BrowserOpen(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/V4/index.php");
    }
    public WebDriverWait ExplicitWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type=\"submit\"]")));
        return wait ;
    }

    @AfterMethod
    public void BrowserTerminate(){
        driver.quit();
    }
}
