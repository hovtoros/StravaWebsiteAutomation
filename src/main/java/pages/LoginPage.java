package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    protected WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginLabel = By.className("mb-0");
    private By alertMessage = By.className("alert-message");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String username){
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
}

    public UserOnBoardingPage SuccessfulLoginButtonClick(){
        driver.findElement(loginButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new UserOnBoardingPage(driver);
    }

    public String UnsuccessfulLoginButtonClick(){
        driver.findElement(loginButton).click();
        return driver.findElement(alertMessage).getText();
    }

    public String InvalidLoginButtonClick(){
        driver.findElement(loginButton).click();
        return driver.findElement(loginLabel).getText();
    }

}
