package com.sayem.pages;


import com.sayem.IPages;
import org.openqa.selenium.WebDriver;


public class GooglePages implements IPages {
    /**
     * Constructor that checks to see we're on Google page.
     *
     * @param driver
     *            {@link WebDriver}
     */
    public GooglePages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("google.com")) {
            throw new IllegalStateException("This is not Google Page");
        }
    }

    /**
     * Search
     * // @see com.carsdirect.framework.web.tests.ISearchPageTestStub#search(java.lang.String)
     */
    public void search(String query) {
        // just a dummy function.
    }
}
