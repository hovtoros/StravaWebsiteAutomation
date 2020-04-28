package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.InvalidLoginPage;
import pages.LoginPage;
import pages.UserOnBoardingPage;

public class LoginFollowingPageDetector {
    private WebDriver driver;
    private By alertMessage = By.className("alert-message");
    private By userNotifications = By.id("notifications");
    private By loginForm = By.id("login_form");
    public UserOnBoardingPage UserOnBoardingPage = null;
    public LoginPage LoginPage = null;
    public InvalidLoginPage InvalidLoginPage = null;

    public LoginFollowingPageDetector(WebDriver driver){
        this.driver = driver;
    }

    public void Detect(){
        if (driver.findElements(userNotifications).size() > 0)
            UserOnBoardingPage = new UserOnBoardingPage(driver);
        else if (driver.findElements(alertMessage).size() > 0)
            InvalidLoginPage = new InvalidLoginPage(driver, alertMessage);
        else if (driver.findElements(loginForm).size() > 0)
            LoginPage = new LoginPage(driver);
    }
}
