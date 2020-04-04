package lab4;

import io.github.bonigarcia.wdm.WebDriverManager;
import lab2.jetpacktravel;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jetpacktravelTest {
    private static WebDriver driver;
    private static jetpacktravel page;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver",
                "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        page = new jetpacktravel(driver, "http://jetpacktravel.ru/");
    }

    @Category(Cat1.class)
    @Test
    public void testCountry() {
        Assert.assertEquals("Получить программу", page.getFirstCountry());
    }

    @Category(Cat2.class)
    @Test
    public void testLogin() {
        Assert.assertEquals(true, page.Login("Name", "123456", "abc@gmail.com", "Spam"));
    }

    @AfterClass
    static public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
