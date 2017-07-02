package pages.part;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static helpers.Locators.get;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by olapanovich on 2.7.17.
 */
public class Menu {

    private static final By MENU_LIST = get("Menu.MenuList");
    private static final By HOME_BUTTON = get("Menu.HomeButton");
    private WebDriverWait wait;

    List<String> MenuItemsTitles = new ArrayList<String>();
    List<String> PagesTitles = new ArrayList<String>();


    private WebDriver driver;
    public Menu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public List<String> catchReferralErrorForLists() {

        List<WebElement> menuList = driver.findElements(MENU_LIST);

        int attempts = 0;
        for (int i = 0; i < menuList.size(); i++) {
            try {
                PagesTitles.add(menuList.get(i).getText());
                menuList.get(i).click();
                menuList = driver.findElements(MENU_LIST);
                attempts = attempts + 1;
                for (int j = attempts; j < menuList.size(); j++) {
                    try {
                        PagesTitles.add(menuList.get(i).getText());
                        menuList.get(j).click();
                        attempts = attempts+1;

                    } catch (StaleElementReferenceException e) {
                        System.out.print("First Catch");
                        menuList = driver.findElements(MENU_LIST);
                        for (int k = attempts; k < menuList.size(); k++) {
                            try {
                                PagesTitles.add(menuList.get(i).getText());
                                menuList.get(k).click();
                                attempts = attempts + 1;
                            } catch (StaleElementReferenceException ea) {
                                System.out.print("Second Catch");
                            }
                        }
                    }

                }
            } catch (StaleElementReferenceException e) {
                System.out.print("Third Catch");

            }
        }
       return PagesTitles;
    }

    public List<String> getMenuItemsTitles() {

        wait.until(visibilityOf(driver.findElement(HOME_BUTTON)));

        List<WebElement> menuItems = driver.findElements(MENU_LIST);

        for (WebElement menuItem: menuItems) {
            MenuItemsTitles.add(menuItem.getText());
        }
        return MenuItemsTitles;
    }

}
