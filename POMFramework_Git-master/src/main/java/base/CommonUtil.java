package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtil {
    public static WebDriver driver;
    Properties properties = new Properties();
    public static EventFiringWebDriver eventFiringWebDriver;
    public static WebEventListener webEventListener;

    public CommonUtil() {
        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
            driver = new ChromeDriver();

            eventFiringWebDriver = new EventFiringWebDriver(driver);
            webEventListener = new WebEventListener();
            eventFiringWebDriver.register(webEventListener);
            driver = eventFiringWebDriver;

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
            properties.load(fileInputStream);
            String url = properties.getProperty("qa.url");
            System.out.println("Url is " + url);
            driver.get(url);
        } catch (FileNotFoundException e) {
            System.out.println("File not found to read properties file");
        } catch (Exception e) {
            System.out.println("Exception during browser set up" + e);
        }
        new FunctionalUtil(driver);
    }

    public static void takeScreenshot() {
        System.out.println("going to take screenshot");
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String name = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
        File destinationFile = new File(System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png");
        System.out.println("path of screenshots\t" + name);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            System.out.println("There is a problem in taking screenshot and saving it");
        }
    }

    public static void closeSession() {
        driver.quit();
        eventFiringWebDriver.unregister(webEventListener);
    }
}
