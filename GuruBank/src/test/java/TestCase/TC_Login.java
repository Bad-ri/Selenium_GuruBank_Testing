package TestCase;

import BrowserFactory.BrowserSetup;
import Utilities.ScreenShot;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login extends BrowserSetup{
    @Test()
    public void ValidLogin () {
        wait.ExplicitWait(login.getLocator());
        login.EnterUsername(data.getAccountUsername());
        login.EnterPassword(data.getAccountPassword());
        login.ClickSubmit();
        String Expected = "Guru99 Bank Manager HomePage" ;
        String Actual = driver.getTitle() ;
        Assert.assertTrue(Expected.contains(Actual));
        log.info("Logged in successfully");
    }
    @Test
    public void inValidLogin(){
        wait.ExplicitWait(login.getLocator());
        login.EnterUsername(fake_data.getMiddleSpecialCharacter(data.getAccountUsername()));
        login.EnterPassword(fake_data.getStartSpecialCharacter(data.getAccountPassword()));
        login.ClickSubmit();
        Alert alert = driver.switchTo().alert();
        String Expected = "User or Password is not valid" ;
        String Actual = alert.getText() ;
        Assert.assertTrue(Expected.contains(Actual));
        log.info("Unsuccessfully login");
    }

}
