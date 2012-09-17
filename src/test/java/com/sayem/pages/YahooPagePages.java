package com.sayem.pages;

import com.sayem.IPages;
import org.openqa.selenium.WebDriver;

public class YahooPagePages implements IPages {

    public YahooPagePages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("yahoo.com")) {
            throw new IllegalStateException("This is not Yahoo Page");
        }
    }

    public void search(String query) {

    }

}
