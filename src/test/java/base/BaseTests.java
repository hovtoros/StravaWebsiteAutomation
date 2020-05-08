package base;

import constants.LoginFormConstants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.UserDashboardPage;
import pages.UserProfilePage;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTests {
    private String websiteLink = "https://www.strava.com/";
    private String dockerHubLink = "http://localhost:4444/wd/hub";
    private EventFiringWebDriver firefoxDriver;
    protected LoginPage loginPage;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
        WebDriver chrome = new RemoteWebDriver(new URL(dockerHubLink), firefoxCapabilities);
        firefoxDriver = new EventFiringWebDriver(chrome);
        firefoxDriver.register(new EventReporter());
        firefoxDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void goLoginPage(){
        firefoxDriver.manage().deleteAllCookies();
        firefoxDriver.get(websiteLink + "login");
        loginPage = new LoginPage(firefoxDriver);
    }

    @AfterClass
    public void tearDown() {
        firefoxDriver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)firefoxDriver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try
            {
                var screenshotsPath = Paths.get("resources", "screenshots");
                if (!Files.exists(screenshotsPath)){
                    Files.createDirectory(screenshotsPath);
                }
                Files.move(
                        screenshot.toPath(),
                        new File(Paths.get(
                                    "resources",
                                "screenshots",
                                        result.getName()
                                        + "_"
                                        + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date())
                                        +".png")
                                .toString())
                                .toPath());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    protected void FillLoginForm(String email, String password){
        loginPage.setEmail(email);
        loginPage.setPassword(password);
    }

    protected UserDashboardPage LoginSuccessfully()
    {
        FillLoginForm(LoginFormConstants.validEmail, LoginFormConstants.validPassword);
        return loginPage.SuccessfulLoginButtonClick();
    }

}