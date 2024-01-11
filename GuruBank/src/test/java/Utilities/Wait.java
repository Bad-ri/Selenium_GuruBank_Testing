package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    WebDriverWait wait ;
    WebDriver driver ;
    public Wait (WebDriver driver){
        this.driver = driver ;
    }
    public WebDriverWait ExplicitWait(String locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return wait ;
    }
}
