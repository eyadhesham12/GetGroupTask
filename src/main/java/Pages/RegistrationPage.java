package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegistrationPage {
    WebDriver driver;

public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    // Locators for elements

    private By firstNameField = By.id("nf-field-17");
    private By lastNameField = By.id("nf-field-18");


    private By emailField = By.id("nf-field-19");
    private By phoneField = By.id("nf-field-20");
    private By selectBooksField = By.xpath("//select[@id='nf-field-22']");
    private By selectBatchMonth  = By.xpath("//select[@id='nf-field-24']");
    private By knowAbout  = By.xpath("//div[@id='primary']//li[2]");
    private By registerButton = By.id("nf-field-15");
    private By successMessage = By.xpath("//p[contains(text(),'Your registration is completed. We will contact wi')]");



    // Methods for interacting with the form

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void selectBooksDropdown(int index) {
        WebElement dropdownElement = driver.findElement(selectBooksField);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    public void selectBatchDropdown(String text) {
        WebElement dropdownElement = driver.findElement(selectBatchMonth);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(text);
    }

    public void checkHwAboutUS() {
        driver.findElement(knowAbout).click();
    }
    public void enterMobile(String mobile) {
        driver.findElement(phoneField).sendKeys(mobile);
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void submitForm() {
        driver.findElement(registerButton).click();
    }

    public String waitForSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return messageElement.getText();
    }

}
