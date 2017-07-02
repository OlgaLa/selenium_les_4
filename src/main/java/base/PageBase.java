package base;

import org.openqa.selenium.WebDriver;
import pages.part.Menu;

/**
 * Created by olapanovich on 2.7.17.
 */
public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() { return driver; }

}



