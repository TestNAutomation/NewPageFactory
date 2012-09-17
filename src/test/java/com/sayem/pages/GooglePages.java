package com.sayem.pages;


import com.sayem.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GooglePages implements TopMenu {
    @FindBy(css = "#gbqfq")
    WebElement searchBox;

    @FindBy(css = "#gbqfb")
    WebElement searchButton;

    public GooglePages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("google.com")) {
            throw new IllegalStateException("This is not Google Page");
        }
    }

    public void search(String query) {
        searchBox.sendKeys(query);
        searchButton.click();

    }
}
