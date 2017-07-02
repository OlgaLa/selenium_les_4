import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyStorePage;
import pages.part.Menu;

import java.util.List;


/**
 * Created by olapanovich on 23.6.17.
 */
public class menuItemsTitlesTest extends TestBase {

    private MyStorePage myStorePage;
    private Menu menu;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private List<String> pageHeaders;
    private List<String> menuItemTitles;

    @BeforeMethod
    public void Login() {
        myStorePage = loginPage.loginToConsole(USERNAME,PASSWORD);
        myStorePage.checkSignOutButton();
        menu = new Menu(driver);
    }

    @Test
    public void checkMenuItems() throws InterruptedException {

        menuItemTitles = menu.getMenuItemsTitles();
        pageHeaders = menu.catchReferralErrorForLists();
        Assert.assertEquals(menuItemTitles,pageHeaders);
    }
}
