package com.qaautomation.pages.FormBugsPages;

import com.qaautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage extends BasePage {

    private By inputFirstName = By.id("firstName");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void inputFirstName(String firstName) {
        WebElement inFirstName = this.driver.findElement(inputFirstName);
        inFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
    }

    public void inputPhoneNunber(String phoneNumber) {
    }

    public void inputCountry(String country) {
    }

    public void inputEmailAddress(String email) {
    }

    public void inputEmailPassword(String pass) {
    }

    public void clicBtnRegister() {
    }

    public void validarMsj(String msj) {
    }
}
