package lab6;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Register {
    private static AndroidDriver driver;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    static MobileElement registerButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    static MobileElement emailEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    static MobileElement usernameEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    static MobileElement passwordEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    static MobileElement confirmPasswordEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    static MobileElement registerFinishButton;

    public Register(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public static void registerNew(String email, String username, String password) {
        registerButton.click();
        (new WebDriverWait(driver, 100)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("registration_email")));
        emailEditText.sendKeys(email);
        usernameEditText.sendKeys(username);
        passwordEditText.sendKeys(password);
        confirmPasswordEditText.sendKeys(password);
        registerFinishButton.click();
        (new WebDriverWait(driver, 100)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email")));
    }
}


