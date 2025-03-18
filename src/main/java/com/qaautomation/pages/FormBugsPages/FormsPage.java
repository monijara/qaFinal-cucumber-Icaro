package com.qaautomation.pages.FormBugsPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormsPage extends BasePage {

    private By inputFirstName = By.id("firstName");
    private By inputLastName= By.id("lastName");
    private By inputPhoneNunber= By.xpath("//input[@id='phone']");
    private By inputEmail= By.id("emailAddress");
    private By inputPassword= By.id("password");

    private By btnRegister= By.id("registerBtn");

    private By lblMsj= By.id("message");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        WebElement inFirstName = this.driver.findElement(inputFirstName);
        inFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement elemento = this.driver.findElement(this.inputLastName);
        elemento.sendKeys(lastName);
    }

    public void inputPhoneNunber(String phoneNumber) {
        WebElement elemento = this.driver.findElement(this.inputPhoneNunber);
        elemento.sendKeys(phoneNumber);
    }

    public void inputCountry(String country) {
    }

    public void inputEmailAddress(String email) {
        WebElement elemento = this.driver.findElement(this.inputEmail);
        elemento.sendKeys(email);
    }

    public void inputEmailPassword(String pass) {
        WebElement elemento = this.driver.findElement(this.inputPassword);
        elemento.sendKeys(pass);
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
