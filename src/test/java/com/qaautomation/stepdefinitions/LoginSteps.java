package com.qaautomation.stepdefinitions;

import com.qaautomation.pages.GmailLoginPage;
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

public class LoginSteps {

    private WebDriver driver;
    private GmailLoginPage gmailLoginPage;
    private String pathtakeScreenshot = System.getProperty("user.dir") + "\\src\\test\\resources\\tests.GmailLoginTest\\";

    private String emailOk = "LamansysTest@gmail.com";
    private String pswOk = "holaMundo1989";

    private String emailInvalid = "LamansysTest@gmail.c";
    private String pswInvalid = "1989holaMundo";

    @Given("que el usuario esta en la pagina de inicio de sesion de Gmail")
    public void queElUsuarioEstaEnLaPaginaDeInicioDeSesionDeGmail() {
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
        driver.get("https://mail.google.com/");
        gmailLoginPage = new GmailLoginPage(driver);
    }

    @When("el usuario ingresa un correo electronico y contrasena validos")
    public void elUsuarioIngresaUnCorreoElectronicoYContrasenaValidos() {
        gmailLoginPage.login(emailOk, pswOk);
    }

    @And("el usuario hace clic en el boton de iniciar sesion")
    public void elUsuarioHaceClicEnElBotonDeIniciarSesion() {
        gmailLoginPage.nextButtonClick();
    }

    @Then("el usuario deberia ver el icono de perfil en la esquina superior derecha")
    public void elUsuarioDeberiaVerElIconoDePerfilEnLaEsquinaSuperiorDerecha() {
        boolean result = gmailLoginPage.isAccountElement(emailOk);
        if (result) {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testValidLogin_OK.jpg");
        } else {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testValidLogin_Fail.jpg");
            Assert.assertTrue("[WARNING] Fallo al iniciar sesion", false);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el navegador despues del escenario
            System.out.println("Navegador cerrado despues del escenario");
        }
    }

    @When("el usuario ingresa un correo electronico valido y una contrasena incorrecta")
    public void elUsuarioIngresaUnCorreoElectronicoValidoYUnaContrasenaIncorrecta() {
        gmailLoginPage.login(emailOk, pswInvalid);
    }

    @Then("el usuario deberia ver un mensaje de error que indica contrasena incorrecta")
    public void elUsuarioDeberiaVerUnMensajeDeErrorQueIndicaContrasenaIncorrecta() {
        String mensajeEsperado = "Contrasena incorrecta. Vuelve a intentarlo o selecciona \"Has olvidado tu contrasena?\" para cambiarla.";
        String msjRecuperado = gmailLoginPage.getMsgErrorPass();
        if (mensajeEsperado.contains(msjRecuperado)) {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidLogin_OK.jpg");
        } else {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidLogin_Fail.jpg");
            Assert.fail("[WARNING] Fallo al iniciar sesion");
        }
    }

    @When("el usuario ingresa un correo electronico invalido y una contrasena valida")
    public void elUsuarioIngresaUnCorreoElectronicoInvalidoYUnaContrasenaValida() {
        gmailLoginPage.sendkeysEmail(emailInvalid);
    }

    @Then("el usuario deberia ver un mensaje de error que indica correo electronico invalido")
    public void elUsuarioDeberiaVerUnMensajeDeErrorQueIndicaCorreoElectronicoInvalido() {
        String mensajeEsperado = "Introduce una direccion de correo electronico o un numero de telefono validos";
        String msjRecuperado = gmailLoginPage.getMsgErrorEmail();
        if (mensajeEsperado.contains(msjRecuperado)) {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidEmail_OK.jpg");
        } else {
            gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidEmail_Fail.jpg");
            Assert.fail("[WARNING] Fallo el mensaje no era lo esperado");
        }
    }

    @When("el usuario ingresa un correo electronico {string} y contrasena {string}")
    public void elUsuarioIngresaUnCorreoElectronicoYContrasena(String email, String pass) {
        gmailLoginPage.login(email, pass);
    }

    @Then("el usuario segun el dato {string} vera el siguiente mensaje {string}")
    public void elUsuarioSengunElDatoVeraElSiguienteMensaje(String LoginOkNoOk, String msjEsperado) {
        if (LoginOkNoOk.contains("Ok")) {
            boolean result = gmailLoginPage.isAccountElement(msjEsperado);
            if (result) {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testValidLogin_OK.jpg");
            } else {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testValidLogin_Fail.jpg");
                Assert.assertTrue("[WARNING] Fallo al iniciar sesion", false);
            }
        }
        if (LoginOkNoOk.contains("passFail")) {
            String msjRecuperado = gmailLoginPage.getMsgErrorPass();
            if (msjRecuperado.contains(msjEsperado)) {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidLogin_OK.jpg");
            } else {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidLogin_Fail.jpg");
                Assert.fail("[WARNING] No es el mensaje esperado");
            }
        }
        if (LoginOkNoOk.contains("emailFail")) {
            String msjRecuperado = gmailLoginPage.getMsgErrorEmail();
            if (msjRecuperado.contains(msjEsperado)) {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidEmail_OK.jpg");
            } else {
                gmailLoginPage.takeScreenshot(pathtakeScreenshot + "\\testInvalidEmail_Fail.jpg");
                Assert.fail("[WARNING] Fallo el mensaje no era lo esperado");
            }
        }
    }

    @And("el usuario hace clic en el boton de iniciar sesion siendo que se espera {string}")
    public void elUsuarioHaceClicEnElBotonDeIniciarSesionSiendoQueSeEspera(String LoginOkNoOk) {
        gmailLoginPage.nextButtonClick();
    }

    @When("el usuario ingresa un correo electronico {string} y contrasena {string} los datos son {string}")
    public void elUsuarioIngresaUnCorreoElectronicoYContrasenaLosDatosSon(String email, String pass, String LoginOkNoOk) {
        if (LoginOkNoOk.contains("Ok") || LoginOkNoOk.contains("passFail")) {
            gmailLoginPage.login(email, pass);
        } else if (LoginOkNoOk.contains("emailFail")) {
            gmailLoginPage.sendkeysEmail(email);
        }
    }


}
