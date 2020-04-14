package lab6;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Expense {
    private AndroidDriver driver;

    @FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
    MobileElement addExpenseButton;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
    MobileElement expenseTitleEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
    MobileElement expenseSumEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
    MobileElement expenseDateEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
    MobileElement expenseCategoryEditText;
    @FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
    MobileElement saveExpenseButton;

    public Expense(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
    }

    public void addExpense(String title, String sum, String date, String cat) {
        addExpenseButton.click();
        (new WebDriverWait(driver, 100)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("new_expense_title_edit")));
        expenseTitleEditText.sendKeys(title);
        expenseSumEditText.sendKeys(sum);
        expenseDateEditText.sendKeys(date);
        expenseCategoryEditText.sendKeys(cat);
        saveExpenseButton.click();
        (new WebDriverWait(driver, 100)).
                until(ExpectedConditions.visibilityOfElementLocated(By.id("add_new_expense")));
    }


}
