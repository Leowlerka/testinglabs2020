package lab6;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;

public class lab6Tests {
    private static AndroidDriverManager driverMan;
    static AndroidDriver driver;

    private static String username = "luntic";
    private static String email = "vupsen@pupsen.com";
    private static String password = "qwerty123";
    private static String title = "Tri topora";
    private static String sum = "777";
    private static String date = "24/07/1999";
    private static String cat = "Azino";

    @BeforeClass
    public static void prepareTest() {
        driverMan = new AndroidDriverManager();
        driver = driverMan.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void quit() {
        driverMan.quitDriver();
    }

    @Before
    public void startApp() {
        driver.launchApp();
    }

    @After
    public void stopApp() {
        driver.closeApp();
    }

    @Test
    public void registerTest() {
        Register reg = new Register(driver);
        reg.registerNew(email, username, password);
        Assert.assertTrue(driver.currentActivity().contains("LoginActivity"));
    }

    @Test
    public void loginTest() {
        Login login = new Login(driver);
        login.enterLogin(email, password);
        Assert.assertTrue(driver.currentActivity().contains("LoginActivity"));
    }

    @Test
    public void addExpenseTest() {
        Register reg = new Register(driver);
        reg.registerNew(email, username, password);
        Assert.assertTrue(driver.currentActivity().contains("LoginActivity"));

        Login login = new Login(driver);
        login.enterLogin(email, password);
        Assert.assertTrue(driver.currentActivity().contains("BudgetActivity"));

        Expense newEpx = new Expense(driver);
        newEpx.addExpense(title, sum, date, cat);
        List<MobileElement> elements = driver.findElementsById("platkovsky.alexey.epamtestapp:id/expense_title");
        Assert.assertEquals(elements.get(4).getText(), title);
    }
}
