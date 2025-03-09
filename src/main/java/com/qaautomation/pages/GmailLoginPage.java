package com.qaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class GmailLoginPage extends BasePage {

    @FindBy(id = "identifierId")
    WebElement emailField;

    @FindBy(xpath = "//span[text()='Siguiente']")
    WebElement nextButton;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id='profileIdentifier']")
    WebElement profileIcon;

    @FindBy(css = "a.gb_A.gb_Wa.gb_X")
    WebElement accountElement;


    public GmailLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        sendkeysEmail(email);
        this.nextButtonClick();
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);

    }

    public void sendkeysEmail(String email) {
        emailField.sendKeys(email);
    }

    public void nextButtonClick() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }


    public boolean isAccountElement(String email) {
        try {
            WebElement isAccountElement = this.wait.until(ExpectedConditions.visibilityOf(accountElement));
            if (isAccountElement.isDisplayed()) {
                String ariaLabel = accountElement.getAttribute("aria-label");
                if (ariaLabel.contains(email.toLowerCase(Locale.ROOT))) {
                    return true;
                } else {
                    return false;
                }

            }
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }

    public String getMsgErrorPass() {
        By msgErrorPass = By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span");
        WebDriverWait WaiMsgErrorPass = new WebDriverWait(driver, Duration.ofSeconds(60));
        return WaiMsgErrorPass.until(ExpectedConditions.visibilityOfElementLocated(msgErrorPass)).getText();
    }

    public String getMsgErrorEmail() {
        // Localizar el elemento usando el XPath proporcionado
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='yDmH0d']/c-wiz/div/div[2]/div/div/div[1]/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
        ));

        // Obtener el texto del elemento
        String msgErrorEmail = elemento.getText();
        return msgErrorEmail;
    }

}
