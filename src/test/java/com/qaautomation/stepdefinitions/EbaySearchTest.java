package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.EbayHomePage;
import com.qaautomation.pages.EbaySearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class EbaySearchTest {
    private WebDriver driver;
    private EbayHomePage ebayHomePage;
    private EbaySearchResultsPage ebaySearchResultsPage;
    private String pathtakeScreenshotEbaySearchTest = System.getProperty("user.dir") + "\\src\\test\\resources\\tests.EbaySearchTest\\";

    @Given("que el usuario navega a la pagina de eBay")
    public void queElUsuarioNavegaALaPaginaDeEBay() {
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
        driver.get("https://www.ebay.com/");
        ebayHomePage = new EbayHomePage(driver);
    }

    @When("el usuario busca el siguiente elemento {string}")
    public void elUsuarioBuscaElSiguienteElemento(String elementoBuscar) {
        this.ebaySearchResultsPage = this.ebayHomePage.searchForItem(elementoBuscar);
    }


    @And("el usuario muestra el precio del primer resultado en la consola")
    public void elUsuarioMuestraElPrecioDelPrimerResultadoEnLaConsola() {
        String price = ebaySearchResultsPage.getFirstItemPrice();
        if (!price.isEmpty()) {
            System.out.println("Price of the first item: " + price);
            ebaySearchResultsPage.takeScreenshot(pathtakeScreenshotEbaySearchTest + "\\testSearchForElectricGuitar_Ok.jpg");
        } else {
            ebaySearchResultsPage.takeScreenshot(pathtakeScreenshotEbaySearchTest + "\\testSearchForElectricGuitar_fail.jpg");
            Assert.fail("[WARNING] Fallo el test testSearchForElectricGuitar");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador después del escenario
            System.out.println("Navegador cerrado después del escenario");
        }
    }


    @When("el usuario busca el siguiente elemento {string} en la categoria {string}")
    public void elUsuarioBuscaElSiguienteElementoEnLaCategoria(String elemento, String categoria) {
        this.ebaySearchResultsPage = this.ebayHomePage.searchForItem(elemento, categoria);
    }
}
