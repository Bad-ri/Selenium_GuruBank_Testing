package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver ;
    public Login (WebDriver driver){
        this.driver = driver ;
    }
    String wait_locator = "//input[@type=\"submit\"]" ;
    By submit_button = By.xpath("//input[@type=\"submit\"]");
    By username_field = By.xpath("//input[@name=\"uid\"]");
    By password_field = By.xpath("//input[@name=\"password\"]");
    public void EnterUsername(String username){
        driver.findElement(username_field).sendKeys(username);
    }
    public void EnterPassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }
    public void ClickSubmit(){
        driver.findElement(submit_button).click();
    }
    public String getLocator(){
        return wait_locator;
    }
}
