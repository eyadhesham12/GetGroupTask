package Tests;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestRegistration {
    WebDriver driver;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://codenboxautomationlab.com/registration-form/");
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSignUp() {
        registrationPage.enterFirstName("Eyad");
        registrationPage.enterLastName("Hesham");
        registrationPage.enterEmail("ehesham@example.com");
        registrationPage.enterMobile("1234567890");
        registrationPage.selectBooksDropdown(1);
        registrationPage.selectBatchDropdown("December");
        registrationPage.checkHwAboutUS();
        registrationPage.submitForm();

        String actualMessage = registrationPage.waitForSuccessMessage();
        String expectedMessage = "Your registration is completed. We will contact with you soon. Thank you !";
        Assert.assertEquals(actualMessage, expectedMessage, "Success message does not match!");


    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
