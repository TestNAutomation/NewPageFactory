package com.sayem.pages;

import com.sayem.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooPages implements TopMenu {

    @FindBy(css = "//*[@title='Search']")
    WebElement searchBox;

    @FindBy(css = "#//*[@id='search-submit']")
    WebElement searchButton;

    public YahooPages(WebDriver driver) {
        if (!driver.getCurrentUrl().contains("yahoo.com")) {
            throw new IllegalStateException("This is not Yahoo Page");
        }
    }

    public void search(String query) {
        searchBox.sendKeys(query);
        searchButton.click();

    }

}
