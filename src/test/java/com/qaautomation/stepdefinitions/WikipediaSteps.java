package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.WikipediaPages.ArticuloPage;
import com.qaautomation.pages.WikipediaPages.WikipediaHomePage;
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

public class WikipediaSteps {
    private WebDriver driver;
    private WikipediaHomePage wikipediaHomePage;
    private ArticuloPage articuloPage;

    @Given("el usuario se encuentra en la home de wikipedia")
    public void elUsuarioSeEncuentraEnLaHomeDeWikipedia() {
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
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        wikipediaHomePage = new WikipediaHomePage(driver);

    }

    @When("el usuario busca el siguiente articulo {string}")
    public void elUsuarioBuscaElSiguienteArticulo(String articulo) {
        wikipediaHomePage.enviarArticuloBuscar(articulo);
    }

    @And("el usuario hace clic el boton buscar de la pagina home")
    public void elUsuarioHaceClicElBotonBuscarDeLaPaginaHome() {
        this.articuloPage = wikipediaHomePage.getArtculoBuscado();
    }

    @Then("el usuario visualiza el resultado {string}")
    public void elUsuarioVisualizaElResultado(String articulo) {
        boolean result = this.articuloPage.buscarTituloArticulo(articulo);
        Assert.assertTrue("[ERROR] No se encontro el titulo buscado: " + articulo, result);
    }

    @After("@BuscarWikiepedia")
    public void tearDown() {
        // Cerrar el navegador
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @And("usuario visualiza titulo {string}")
    public void usuarioVisualizaTitulo(String titulo) {
        this.articuloPage.buscarTitulo(titulo);
    }


}
