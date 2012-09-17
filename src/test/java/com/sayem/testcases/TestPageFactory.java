package com.sayem.testcases;

import com.sayem.IPages;
import com.sayem.base.PageFactory;
import com.sayem.pages.GooglePages;
import com.sayem.pages.YahooPagePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.thoughtworks.selenium.SeleneseTestBase.assertFalse;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;


public class TestPageFactory {

    WebDriver driver;

    /**
     * @throws java.lang.Exception
     */
    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() {
        driver.get("http://www.google.com");
        IPages page = PageFactory.constructPage(driver,
                IPages.class);
        //See we are on a Google page.
        assertTrue(page instanceof GooglePages);
        assertFalse(page instanceof YahooPagePages);

        driver.get("http://www.yahoo.com");
        page = PageFactory.constructPage(driver,
                IPages.class);
        //See we are not on a Yahoo page.
        assertTrue(page instanceof YahooPagePages);
        assertFalse(page instanceof GooglePages);
    }

}
