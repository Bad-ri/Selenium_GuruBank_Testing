import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_1 {
    WebDriver driver ;
    WebDriverWait wait ;
    By title_locator = By.xpath("//div/h5") ;
    @BeforeMethod
    public void BrowserSetup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test
    public void RelativeLocators() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(title_locator));
        WebElement title = driver.findElement(title_locator);
        Thread.sleep(2000);

        WebElement username = driver.findElement(RelativeLocator.with(By.tagName("p")).toLeftOf(title));
        System.out.println(username.getText());


    }
    @AfterMethod
    public void Terminate(){
        driver.quit();
    }
}
