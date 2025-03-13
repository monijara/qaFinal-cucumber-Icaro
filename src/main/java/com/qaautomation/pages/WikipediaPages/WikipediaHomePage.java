package com.qaautomation.pages.WikipediaPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WikipediaHomePage extends BasePage {

    private By searchText = By.id("searchInput");
    private By btnSearch = By.xpath("//*[@id=\"searchform\"]/div/button[text()=\"Buscar\"]");

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
    }

    public void enviarArticuloBuscar(String articulo) {
        WebElement inputText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.searchText));
        inputText.sendKeys(articulo);
    }

    public void clicBtnBuscar() {
        WebElement btnSearch = this.wait.until(ExpectedConditions.elementToBeClickable(this.btnSearch));
        btnSearch.click();
    }

    public ArticuloPage getArtculoBuscado() {
        WebElement btnSearch = this.wait.until(ExpectedConditions.elementToBeClickable(this.btnSearch));
        btnSearch.click();
        return new ArticuloPage(this.driver);
    }
}
