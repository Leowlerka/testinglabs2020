package lab4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class steps {
    WebDriver driver;
    jetpacktravel pageJet;
    myshows pageMS;
    myshowsprofile pageMSP;

    @Given("^User is on the Jetpacktravel page$")
    public void beforeTestJet() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver",
                "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        pageJet = new jetpacktravel(driver, "http://jetpacktravel.ru/");
    }

    @When("^Log in jet$")
    public void loginJet() {
        Assert.assertEquals(true, pageJet.Login("Name", "123456", "abc@gmail.com", "Spam"));
    }

    @Then("^Test the first country$")
    public void testCountry() {
        Assert.assertEquals("Получить программу", pageJet.getFirstCountry());
    }

    @Then("^Close Firefox$")
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("^User is on the MyShows page$")
    public void beforeTestMyShows() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver", "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        pageMS = new myshows(driver, "https://myshows.me/login");
    }

    @When("^Log in MyShows$")
    public void loginMyShows() {
        Assert.assertEquals("Пользователь с таким логином/E-mail и паролем не найден :(",
                pageMS.Login("abc@gmail.com", "1234"));
    }

    @Then("^Test serials$")
    public void testSerials() {
        Assert.assertEquals("Сериалы", pageMS.getSerials());
    }


    @Given("^User is on the MyShowsProfile page$")
    public void beforeTestMSP() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.setProperty("webdriver.firefox.driver",
                "C:\\Users\\ASUS\\Documents\\IdeaProjects\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        pageMSP = new myshowsprofile(driver, "https://myshows.me/LerkaXd");
    }

    @When("^Test name$")
    public void testName() {
        Assert.assertEquals("LerkaXd", pageMSP.getName());
    }

    @Then("^Test reward$")
    public void testReward() {
        Assert.assertEquals("Фантаст II", pageMSP.getReward());
    }
}
