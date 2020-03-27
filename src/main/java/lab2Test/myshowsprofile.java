package lab2Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class myshowsprofile {
    private WebDriver driver;
    By userName = By.xpath("/html/body/div[1]/div/div/main/h1");
    By award = By.xpath("/html/body/div[1]/div/div/aside/div[1]/div[1]/div/a/p[2]");

    public myshowsprofile(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        (new WebDriverWait(driver, 100)).until((ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase().contains("lerkaxd"));
    }

    public String getReward() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/aside/div[1]/div[1]/div/a/p[2]")).getText();
    }

    public String getName() {
        return driver.findElement(By.xpath("/html/body/div[1]/div/div/main/h1")).getText();
    }
}
