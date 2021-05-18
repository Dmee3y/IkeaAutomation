package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
//import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BaseTest {
    //private EventFiringWebDriver driver;// = new EventFiringWebDriver(new ChromeDriver());
    private ChromeDriver driver;
    private String link = "https://www.ikea.com/ru/ru/";
    protected HomePage homePage;


    @BeforeClass
    public void setUp() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        //driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions())); //new ChromeDriver();
        //driver.register(new EventReporter());
        WebDriverManager.chromedriver().setup(); //works for webdriver mngr, no need to Path
        driver = new ChromeDriver();
        //driver.get(link);
        driver.manage().window().maximize();
        goHome();
        //setCookie();
        homePage = new HomePage(driver);



    }
    @BeforeMethod
    public void goHome() {
        driver.get(link);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

//    public static void main(String[] args) throws InterruptedException {
//        BaseTest test = new BaseTest();
//        test.setUp();
//        test.tearDown();
//    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }


    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        System.out.println(screenshot.getAbsolutePath());

        com.google.common.io.Files.move
                (screenshot, new File("src/test/resources/screenshots/screenshot_" + result.getName() + ".png"));

    }

    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result);
        }
    }

    //removes "Browser is being controlled..." message & makes testing HEADLESS
    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        //chromeOptions.setHeadless(true);
        return chromeOptions;
    }

//    private void setCookie() {
//        Cookie cookie = new Cookie
//                .Builder("Stormnet", "123")
//                .domain("the-internet.herokuapp.com")
//                .build();
//
//        driver.manage().addCookie(cookie);

    // DELETE cookie settings
    //driver.manage().deleteCookieNamed("optimizelyBuckets");
//    }
}