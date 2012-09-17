package com.sayem.pages;

import com.sayem.TopMenu;
import org.openqa.selenium.WebDriver;

public class YahooPages implements TopMenu {

    public YahooPages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("yahoo.com")) {
            throw new IllegalStateException("This is not Yahoo Page");
        }
    }

    public void search(String query) {

    }

}
