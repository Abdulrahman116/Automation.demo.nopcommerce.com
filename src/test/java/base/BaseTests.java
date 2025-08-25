package base;

import UtilTests.UtilTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTests {

    public WebDriver driver;
    public HomePage homePage;
    UtilTests utilTests;

    String myWebsite = "https://demo.nopcommerce.com/";

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);

        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        //goHome();
        driver.get(myWebsite);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        //driver.get(myWebsite);
    }
    @AfterMethod
    public void setStatus(Method method, ITestResult result) throws IOException {
        utilTests = new UtilTests(driver);
        utilTests.setTestCaseStatus(method, result);
        utilTests.takeScreenShot(method.getName());
    }
    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeSuite
    public void startSuite(){
        utilTests = new UtilTests(driver);
        utilTests.createReport();
    }
    @AfterSuite
    public void endSuite(){
        utilTests = new UtilTests(driver);
        utilTests.flushReport();
    }

}