package testSuite;

import base.CommonUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.ContactUsPage;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class TestHomePage extends CommonUtil {

    @Test
    public void searchText() {
        takeScreenshot();
        HomePage.searchTextBox(driver).sendKeys("Printed dress");
        takeScreenshot();

    }

    @After
    public void shutDown() {
        closeSession();
    }

    public static void main(String[] args) {
        new TestHomePage().searchText();

    }

}
