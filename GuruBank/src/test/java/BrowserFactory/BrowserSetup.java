package BrowserFactory;

import Data.DataGenerator;
import Data.DataRetriever;
import Pages.Login;
import Utilities.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.ILoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BrowserSetup {
    public WebDriver driver ;
    public Login login ;
    public Wait wait ;
    public DataRetriever data;
    public DataGenerator fake_data ;
    public Logger log ;
    public FileHandler file ;

    @BeforeMethod
    public void BrowserOpen(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--headless");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.addArguments("--disable-web-security");
        //options.addArguments("--no-proxy-server");
        //options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--enable-automation");
        driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/V4/index.php");
        objectSetup();
        logSetup();
        log.info("website opened");
    }
    public void objectSetup(){
        login = new Login(driver);
        wait = new Wait(driver);
        data = new DataRetriever(1);
        fake_data = new DataGenerator();
        log = Logger.getAnonymousLogger();
    }
    public void logSetup(){
        try{
            file = new FileHandler("C:\\Users\\Badri\\Documents\\GitHub\\Selenium_GuruBank_Testing\\GuruBank\\src\\test\\Artifacts\\logs.log",true);
            file.setFormatter(new SimpleFormatter());
            log.addHandler(file);
            //log.info("--------------------------------RUN---------------------------------------");
        }catch (IOException e){
            log.severe("file not found");
        }

    }
    public void logTerminate (){
        log.removeHandler(file);
        file.close();
    }

    @AfterMethod
    public void BrowserTerminate(){
        driver.quit();
        log.info("website closed");
        logTerminate();
    }
}
