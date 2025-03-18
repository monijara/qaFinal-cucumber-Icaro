package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.FormBugsPages.FormsPage;
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

public class BugsFormSteps {
    private FormsPage formsPage;
    private WebDriver driver;

    @Given("el usuario se encuentra en la home de BugsForm")
    public void elUsuarioSeEncuentraEnLaHomeDeBugsForm() {
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
        driver.get("https://qa-practice.netlify.app/bugs-form");
        formsPage = new FormsPage(driver);
    }

    @When("el usuario ingres First Name {string}")
    public void elUsuarioIngresFirstName(String firstName) {
        this.formsPage.inputFirstName(firstName);
    }

    @And("el usuario ingres Last Name {string}")
    public void elUsuarioIngresLastName(String lastName) {
        this.formsPage.inputLastName(lastName);
    }

    @And("el usuario ingres Phone nunber {string}")
    public void elUsuarioIngresPhoneNunber(String phoneNumber) {
        this.formsPage.inputPhoneNunber(phoneNumber);
    }

    @And("el usuario ingres Country {string}")
    public void elUsuarioIngresCountry(String country) {
        this.formsPage.inputCountry(country);
    }

    @And("el usuario ingres Email address {string}")
    public void elUsuarioIngresEmailAddress(String email) {
        this.formsPage.inputEmailAddress(email);
    }

    @And("el usuario ingres Email Password {string}")
    public void elUsuarioIngresEmailPassword(String pass) {
        this.formsPage.inputEmailPassword(pass);
    }

    @And("el usuario hace clic boton Register")
    public void elUsuarioHaceClicBotonRegister() {
        this.formsPage.clicBtnRegister();
    }

    @Then("el usuario visualiza el mensaje {string}")
    public void elUsuarioVisualizaElMensaje(String msj) {
        String mnsjRecuperado = this.formsPage.validarMsj();
        Assert.assertEquals("[Error] El mensaje no es lo esoeradi",msj,mnsjRecuperado);
    }

    @After
    public void tearDown() {
        // Cerrar el navegador
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
