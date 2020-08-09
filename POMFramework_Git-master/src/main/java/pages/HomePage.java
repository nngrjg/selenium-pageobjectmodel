package pages;

import base.CommonUtil;
import base.FunctionalUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class HomePage {

    public static WebElement element = null;

    public static WebElement contactUsLink(WebDriver driver) {
        element = driver.findElement(By.linkText("Contact us"));
        return element;
    }

    public static WebElement signInLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        return element;
    }

    public static WebElement dressesLink(WebDriver driver) {
        element = driver.findElement(By.xpath("(//a[text()='Dresses' and @title='Dresses'])[2]"));
        return element;
    }

    public static WebElement searchTextBox(WebDriver driver) {
        element = driver.findElement(By.id("search_query_top"));
        return element;
    }


}
