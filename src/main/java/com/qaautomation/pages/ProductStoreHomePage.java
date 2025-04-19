package com.qaautomation.pages.WikipediaPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductStoreHomePage extends BasePage {
    private By searchText = By.id("nava");

    public ProductStoreHomePage(WebDriver driver) {
        super(driver);
    }

    public String buscarCabecera() {
        WebElement inputText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.searchText));
        return inputText.getText();
    }
}
