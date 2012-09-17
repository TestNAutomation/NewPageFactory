package com.sayem.pages;


import com.sayem.IPages;
import org.openqa.selenium.WebDriver;


public class GooglePages implements IPages {

    public GooglePages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("google.com")) {
            throw new IllegalStateException("This is not Google Page");
        }
    }


    public void search(String query) {

    }
}
