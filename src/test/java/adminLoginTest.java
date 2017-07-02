import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyStorePage;


/**
 * Created by olapanovich on 23.6.17.
 */
public class adminLoginTest extends TestBase {

    private MyStorePage myStorePage;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String EXPECTED_TITLE = "My Store";


    @Test
    public void adminPanelLoginTest() {
        myStorePage = loginPage.loginToConsole(USERNAME,PASSWORD);
        Assert.assertTrue(myStorePage.checkSignOutButton(), "User doesn't login");
    }

}


