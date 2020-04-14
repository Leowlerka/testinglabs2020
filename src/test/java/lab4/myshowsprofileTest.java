package lab4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myshowsprofileTest {
    private static WebDriver driver;
    public static myshowsprofile page;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver",
                "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        page = new myshowsprofile(driver, "https://myshows.me/LerkaXd");
    }

    @Category(Cat1.class)
    @Test
    public void testName() {
        Assert.assertEquals("Фантаст II", page.getReward());
    }

    @Category(Cat2.class)
    @Test
    public void testReward() {
        Assert.assertEquals("LerkaXd", page.getName());
    }

    @AfterClass
    static public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
