package com.sayem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestNewPageFactory {

    WebDriver driver;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test() {
        driver.get("http://www.google.com");
        ISearchPage page = NewPageFactory.constructPage(driver,
                ISearchPage.class);
        //See we are on a Google page.
        assertTrue(page instanceof GoogleSearchPage);
        assertFalse(page instanceof YahooPageSearchPage);

        driver.get("http://www.yahoo.com");
        page = NewPageFactory.constructPage(driver,
                ISearchPage.class);
        //See we are not on a Yahoo page.
        assertTrue(page instanceof YahooPageSearchPage);
        assertFalse(page instanceof GoogleSearchPage);
    }

}
