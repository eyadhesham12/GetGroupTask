package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// This Class not Used but it related the first link


public class LoginPage {
    WebDriver driver;

public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submitBTN");




    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
            driver.findElement(passwordField).sendKeys(password);
        }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}


