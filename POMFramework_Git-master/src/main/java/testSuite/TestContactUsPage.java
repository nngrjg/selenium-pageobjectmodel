package testSuite;

import base.CommonUtil;
import org.junit.After;
import org.junit.Test;
import pages.ContactUsPage;

public class TestContactUsPage extends CommonUtil{

    @Test
    public void fillthepage(){
        ContactUsPage.clickcontactuspage(driver).click();
        takeScreenshot();
        ContactUsPage.emailid(driver).sendKeys("test@mail.com");
    }

    @After
    public void shutDown() {
        closeSession();
    }

    public static void main(String[] args) {
        new TestContactUsPage().fillthepage();

    }

        }