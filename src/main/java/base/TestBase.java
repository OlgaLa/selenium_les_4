package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by olapanovich on 2.7.17.
 */
public class TestBase {

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/admin");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
