package com.qaautomation.pages.FormBugsPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormsPage extends BasePage {

    private final By inputFullName = By.id("name");
    private final By inputPhoneNunber= By.id("phone");
    private final By inputEmail= By.id("email");
    private final By inputMessage= By.id("message");
    private final By btnRegister= By.id("submitButton");

    private final By lblMsj= By.cssSelector("#submitSuccessMessage .fw-bolder");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void inputFullName(String name) {
        WebElement inFirstName = this.driver.findElement(inputFullName);
        inFirstName.sendKeys(name);
    }

    public void inputEmailAddress(String email) {
        WebElement elemento = this.driver.findElement(this.inputEmail);
        elemento.sendKeys(email);
    }

    public void inputPhoneNunber(String phoneNumber) {
        WebElement elemento = this.driver.findElement(this.inputPhoneNunber);
        elemento.sendKeys(phoneNumber);
    }

    public void inputMessage(String message) {
        WebElement elemento = this.driver.findElement(this.inputMessage);
        elemento.sendKeys(message);
    }

    public void clicBtnRegister() {
        WebElement elemento = this.wait.until(ExpectedConditions.elementToBeClickable(btnRegister));
        elemento.click();
    }

    public boolean validarMsj(String msj) {
        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblMsj));
        if(elemento.getText().contentEquals(msj)){
            System.out.println("[INFO] El mensaje es el esperado");
            return true;
        }else {
            System.out.println("[INFO] El mensaje no es el esperado");
            return false;
        }
    }

    public String  validarMsj() {
        WebElement elemento = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.lblMsj));
        return elemento.getText();
    }
}
