package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver ;
    public Login (WebDriver driver){
        this.driver = driver ;
    }
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
}
