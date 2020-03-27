package lab2Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class jetpacktravel {
    private WebDriver driver;
    By usernameLocator = By.xpath("/html/body/div[1]/div[9]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/input");
    By phoneLocator = By.xpath("/html/body/div[1]/div[9]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[1]/input[1]");
    By mailLocator = By.xpath("/html/body/div[1]/div[9]/div/div[2]/div/div/form/div[2]/div[3]/div[2]/input");
    By textLocator = By.xpath("/html/body/div[1]/div[9]/div/div[2]/div/div/form/div[2]/div[4]/div[2]/textarea");

    public jetpacktravel(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        (new WebDriverWait(driver, 100)).until((ExpectedCondition<Boolean>) d -> d.getTitle().toLowerCase().contains("jetpack travel"));
    }

    public boolean Login(String username, String phone, String mail, String text) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(phoneLocator).sendKeys(phone);
        driver.findElement(mailLocator).sendKeys(mail);
        driver.findElement(textLocator).sendKeys(text);
        driver.findElement(By.xpath("/html/body/div[1]/div[9]/div/div[2]/div/div/form/div[2]/div[6]/button")).click();
        return true;
    }

    public String getFirstCountry() {
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/a/table/tbody/tr/td")).getText();
    }
}




    /*
    @FindBy(className = "t228__list_item")
    private List<WebElement> toolbarItems;

    @FindBy(className = "t228__right_social_links_item")
    private List<WebElement> links;

    @FindBy(how = How.CLASS_NAME, using = "js-click-stat")
    private WebElement startBottom;

    @FindBy(className = "t-cover__arrow-svg")
    private WebElement nextBottom;

    @FindBy(className = "t774__col:nth-child(1)")
    private WebElement country1Link;

    @FindBy(className = "t774__col:nth-child(2)")
    private WebElement country2Link;

    @FindBy(className = "t774__col:nth-child(3)")
    private WebElement country3Link;

    @FindBy(className = "t-animate")
    private WebElement program;

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "name")
    private WebElement tel;

    @FindBy(how = How.ID, using = "div.t-input-group:nth-child(3) > div:nth-child(2) > input:nth-child(1)")
    private WebElement mail;

    @FindBy(how = How.CLASS_NAME, using = "textarea.t-input")
    private WebElement text;

     */
