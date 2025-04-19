package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.WikipediaPages.ArticuloPage;
import com.qaautomation.pages.WikipediaPages.ProductStoreHomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ProductStoreSteps {
    private WebDriver driver;
    private ProductStoreHomePage productStoreHomePage;

    @Given("el usuario se encuentra en la home de Product Store")
    public void elUsuarioSeEncuentraEnLaHomeDeProductStore() {
        ChromeOptions options = new ChromeOptions();
        String pathChromeDriver = System.getProperty("user.dir") + "\\src\\main\\drivers\\chromedriver.exe";
        System.out.println("[Info]Ruta driver " + pathChromeDriver);
        System.setProperty("webdriver.chrome.driver", pathChromeDriver);

        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setPageLoadTimeout(Duration.ofSeconds(60));

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com/index.html");
        productStoreHomePage = new ProductStoreHomePage(driver);
    }

    @When("el usuario entra")
    public void elUsuarioEntra() {
//        productStoreHomePage.enviarArticuloBuscar(articulo);
    }

    @Then("el usuario visualiza el titulo {string}")
    public void elUsuarioVisualizaElTitulo(String titulo) {
        String result = this.productStoreHomePage.buscarCabecera();
        boolean esValido = result.contentEquals(titulo);
        System.out.println(esValido ? "El titulo buscado es el correcto" : "El titulo no es correcto");
        Assert.assertTrue("[ERROR] No se encontro el titulo buscado: " + titulo, esValido);
    }

    @After("@BuscarWikiepedia")
    public void tearDown() {
        // Cerrar el navegador
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}

