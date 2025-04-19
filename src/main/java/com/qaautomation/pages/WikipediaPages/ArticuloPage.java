package com.qaautomation.pages.WikipediaPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArticuloPage extends BasePage {


    public ArticuloPage(WebDriver driver) {
        super(driver);
    }

    public boolean buscarTituloArticulo(String articulo) {
        String xpathTitle = "//h1[@id='firstHeading' ]/span[text()=\"" + articulo + "\"]";
        By tituloArticulo = By.xpath(xpathTitle);
        try {
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(tituloArticulo));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean buscarTitulo(String titulo) {
        //Buscar el WebElement h2 con el id  "Historia" y validar que el texto que muestra sea "Historia"

        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Historia")));
        if (elemento.getText().contentEquals(titulo)) {
            System.out.println("[INFO] El mensaje es el esperado   " + titulo);
            return true;
        } else {
            System.out.println("[INFO] El mensaje no es el esperado   " + titulo);
            return true;
        }
    }
}

