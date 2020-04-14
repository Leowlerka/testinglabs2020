package lab6;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverManager {
    static AppiumDriverLocalService appiumDriverLocal = null;
    public static AndroidDriver driver;

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (appiumDriverLocal != null) {
            appiumDriverLocal.stop();
            appiumDriverLocal = null;
        }
    }

    public AndroidDriver getDriver() {
        if (driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }

    protected void startService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort();
        builder.withAppiumJS(new File(
                "C:\\Users\\ASUS\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        AppiumDriverLocalService appiumDriverLocal = builder.build();
        AndroidDriverManager.appiumDriverLocal = appiumDriverLocal;
        appiumDriverLocal.start();
    }

    protected void createDriver() {
        DesiredCapabilities capab = DesiredCapabilities.android();
        capab.setCapability("device", "android");
        capab.setCapability("deviceName", "Leowlerka");
        capab.setCapability("platformName", "Android");
        capab.setCapability("udid", "QXE7N18728011794");
        capab.setCapability("automationName", "UiAutomator2");
        capab.setCapability(MobileCapabilityType.APP, "C:\\Users\\ASUS\\Documents\\IdeaProjects\\testinglabs2020\\app-debug.apk");
        capab.setCapability("--local-timezone", "false");
        capab.setCapability("autoGrantPermissions", "true");
        capab.setCapability("orientation", "PORTRAIT");
        capab.setCapability("appWaitDuration", 30000);
        capab.setCapability("disabledAndroidWatchers", "true");
        capab.setCapability("app-wait-activity", "activity-to-wait-for");
        driver = new AndroidDriver<MobileElement>(appiumDriverLocal.getUrl(), capab);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capab);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
