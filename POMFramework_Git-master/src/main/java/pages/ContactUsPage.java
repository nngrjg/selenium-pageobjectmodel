package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    public static WebElement element = null;

    public static WebElement emailid (WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@data-validate=\"isEmail\"]"));
        return element;
    }
    public static WebElement clickcontactuspage (WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@title=\"Contact us\"]"));
        return element;
    }


}
