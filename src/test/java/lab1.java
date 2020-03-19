import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class lab1 {
    WebDriver driver;

    @BeforeClass
    public void prepareDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
    }

    @Test
    public void search() {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q")); //By.xpath("//input[@id='text']"));
        element.sendKeys("steam");
        element.submit();
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("steam");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        WebElement elem = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("steam", elem.getText().toLowerCase());
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
