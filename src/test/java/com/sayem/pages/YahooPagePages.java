package com.sayem.pages;

import com.sayem.IPages;
import org.openqa.selenium.WebDriver;

public class YahooPagePages implements IPages {

    /**
     * Constructor that checks to see we're on Google page.
     *
     * @param driver
     *            {@link WebDriver}
     */
    public YahooPagePages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("yahoo.com")) {
            throw new IllegalStateException("This is not Yahoo Page");
        }
    }

    /**
     * Search
     *
     * //@see com.carsdirect.framework.web.tests.ISearchPageTestStub#search(java.lang.String)
     */
    public void search(String query) {
        // Dummy function
    }

}
