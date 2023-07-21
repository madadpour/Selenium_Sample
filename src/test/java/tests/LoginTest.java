package tests;
import excel.testDataGenerator;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.loginPage;


public class LoginTest {
    loginPage login = new loginPage();
    ChromeOptions options = new ChromeOptions();
    WebDriver driver = new ChromeDriver(options);

    @BeforeClass
    public void installDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        options.addArguments("ignore-certificate-errors");
        options.setAcceptInsecureCerts(true);
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "login", dataProviderClass = testDataGenerator.class)
    public void PositiveLogin(String[] loginData) {
        login.PositiveLogin(driver, loginData);
    }

    @Test(dataProvider = "loginNeg", dataProviderClass = testDataGenerator.class)
    public void NegativeLogin(String[] loginNegData) {

        login.NegativeLogin(driver, loginNegData);

    }
    @AfterTest
    public  void close(){
        driver.close();
        driver.quit();
    }

  }
