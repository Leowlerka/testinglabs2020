package lab4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myshows {
    private WebDriver driver;
    By mailLocator = By.xpath("//*[@id=\"ff01\"]");
    By passLocator = By.xpath("//*[@id=\"ff02\"]");

    public myshows(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        (new WebDriverWait(driver, 100)).until((ExpectedCondition<Boolean>)
                d -> d.getTitle().toLowerCase().contains("myshows"));
    }

    public String Login(String mail, String pass) {
        driver.findElement(mailLocator).sendKeys(mail);
        driver.findElement(passLocator).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[3]/div/button")).click();
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/main/form/div[1]/div/span/span")).getText();
    }

    public String getSerials() {
        return driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/ul/li[1]/a")).getText();
    }
}