package com.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EbayHomePage extends BasePage {

    @FindBy(id = "gh-ac")
    WebElement searchBox;

    @FindBy(id = "gh-search-btn")
    WebElement searchButton;

    @FindBy(id = "gh-cat")
    WebElement selectElement;

    public EbayHomePage(WebDriver driver) {
        super(driver);
    }


    public EbaySearchResultsPage searchForItem(String item) {
        searchBox.sendKeys(item);
        this.wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        return new EbaySearchResultsPage(driver);
    }

    public EbaySearchResultsPage searchForItem(String item,String Categoria) {
        searchBox.sendKeys(item);

        // Crear objeto Select
        Select select = new Select(selectElement);
        // Obtener todas las opciones del select
        List<WebElement> opciones = select.getOptions();
        System.out.println("Opciones disponibles:");
        // Recorrer y mostrar todas las opciones
        for (WebElement opcion : opciones) {
            System.out.println(opcion.getText()); // Imprime el texto visible de cada opción
        }

        // Seleccionar una opción específica (por valor)
        select.selectByValue("619"); // Selecciona "Tele" en este caso
        // Alternativamente, seleccionar por índice o texto visible:
        // select.selectByIndex(1); // Selecciona la segunda opción
        //select.selectByVisibleText("Instrumentos y equipos musicales"); // Selecciona por el texto que ve el usuario



        this.wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        return new EbaySearchResultsPage(driver);
    }
}
