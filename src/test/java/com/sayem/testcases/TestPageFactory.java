package com.sayem.testcases;

import com.sayem.TopMenu;
import com.sayem.base.PageFactory;
import com.sayem.pages.GooglePages;
import com.sayem.pages.YahooPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertFalse;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class TestPageFactory {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://www.google.com");
        TopMenu page = PageFactory.constructPage(driver,TopMenu.class);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        page.search("Selenium");

        // I am using it for temporary
        Thread.sleep(30000);

        //See we are on a Google page.
        assertTrue(page instanceof GooglePages);
        assertFalse(page instanceof YahooPages);



        driver.navigate().to("http://www.yahoo.com");
        page = PageFactory.constructPage(driver, TopMenu.class);

        page.search("Selenium");
        // I am using it for temporary
        Thread.sleep(30000);

        //See we are not on a Yahoo page.
        assertTrue(page instanceof YahooPages);
        assertFalse(page instanceof GooglePages);

    }

}
