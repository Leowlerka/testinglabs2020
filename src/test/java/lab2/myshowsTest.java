package lab2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myshowsTest {
    private static WebDriver driver;
    public static myshows page;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        page = new myshows(driver, "https://myshows.me/login");
    }

    @Category(Cat1.class)
    @Test
    public void testSerials() {
        Assert.assertEquals("Сериалы", page.getSerials());
    }

    @Category(Cat2.class)
    @Test
    public void testLogin() {
        Assert.assertEquals("Пользователь с таким логином/E-mail и паролем не найден :(",
                page.Login("abc@gmail.com", "1234"));
    }

    @AfterClass
    static public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}