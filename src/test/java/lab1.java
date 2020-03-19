import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class lab1 {
    static WebDriver driver;

    @BeforeClass
    static public void prepareDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    }

    @Test
    public void search() {
        driver.get("http://www.yandex.ru");
        WebElement element = driver.findElement(By.xpath("//input[@id='text']"));
        element.sendKeys("nnm-club.name");
        element.submit();
        WebElement elem = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"search-result\"]/li[1]/div/div[1]/div[1]/a/b")));
        System.out.println("The page is: " + elem.getText());
        Assert.assertEquals("nnmclub.ro", elem.getText().toLowerCase());
    }
    @AfterClass
    static public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

