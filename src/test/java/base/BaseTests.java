package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.EventReporter;

import java.nio.file.Paths;

public class BaseTests {
    private String websiteLink = "https://www.strava.com/";
    private EventFiringWebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", Paths.get("resources","chromedriver.exe").toString());
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goLoginPage(){
        driver.manage().deleteAllCookies();
        driver.get(websiteLink + "login");
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    protected void FillLoginForm(String email, String password){
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }
}