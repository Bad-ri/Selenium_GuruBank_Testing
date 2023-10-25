package TestCase;

import BrowserFactory.BrowserSetup;
import Pages.Login;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class TC_Login extends BrowserSetup{
    @Test
    public void ValidLogin () throws InterruptedException {
        Login login = new Login(driver);
        ExplicitWait();
        login.EnterUsername("mohamed");
        login.EnterPassword("mahmoud");
        login.ClickSubmit();
        Alert alert = driver.switchTo().alert();
        String result = alert.getText();
        System.out.println(result);
    }

}
