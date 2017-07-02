package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.part.Menu;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import static helpers.Locators.get;


/**
 * Created by olapanovich on 2.7.17.
 */
public class MyStorePage extends PageBase{


    private static final By SIGNOUTBUTTON = get("MyStorePage.SignOutButton");
    private Menu menu;
    private WebDriverWait wait;

    public MyStorePage(WebDriver driver) {
        super(driver);
        menu = new Menu(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public Menu getMenu() { return menu; }

    public boolean checkSignOutButton() {
       try {
           wait.until(visibilityOf(driver.findElement(SIGNOUTBUTTON)));
           return true;
       }
       catch (NoSuchElementException e) {
            return false;
       }
    }



}
