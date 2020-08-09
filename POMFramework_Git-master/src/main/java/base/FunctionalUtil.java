package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FunctionalUtil {
    private static WebDriver driver;

    FunctionalUtil(WebDriver driver) {
        FunctionalUtil.driver = driver;
    }

    public static void actionsClick(WebElement element1,WebElement element2) {
        System.out.println("going to click using actions");
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).moveToElement(element2).click().perform();
    }
}
