package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

/**
 * Created by olapanovich on 2.7.17.
 */
public class LoginPage extends PageBase {

    private static final By USERNAME = get("LoginPage.UserName");
    private static final By PASSWORD = get("LoginPage.Password");
    private static final By LOGINBUTTON = get("LoginPage.LoginButton");

    public LoginPage(WebDriver driver) { super(driver); }

    public MyStorePage loginToConsole(String username, String password) {

        driver.findElement(USERNAME).sendKeys(username);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGINBUTTON).click();
        return new MyStorePage(driver);
    }

}
