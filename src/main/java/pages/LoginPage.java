package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    protected WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginLabel = By.className("mb-0");
    private By alertMessage = By.className("alert-message");
    public String errorMessage = null;

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
        return new UserOnBoardingPage(driver);
    }

    public void UnsuccessfulLoginButtonClick(){
        driver.findElement(loginButton).click();
        errorMessage =  new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(alertMessage)).getText();
    }

    public String InvalidLoginButtonClick(){
        driver.findElement(loginButton).click();
        return driver.findElement(loginLabel).getText();
    }

}
