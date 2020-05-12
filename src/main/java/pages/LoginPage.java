package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By loginLabel = By.className("mb-0");
    private By alertMessage = By.className("alert-message");
    public String errorMessage = null;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 3);
    }

    public void setEmail(String username){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField)).sendKeys(username);
    }

    public void setPassword(String password){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordField)).sendKeys(password);
}

    public UserDashboardPage SuccessfulLoginButtonClick(){
        driver.findElement(loginButton).click();
        return new UserDashboardPage(driver);
    }

    public void UnsuccessfulLoginButtonClick(){
        driver.findElement(loginButton).click();
        errorMessage =  wait.until(ExpectedConditions.presenceOfElementLocated(alertMessage)).getText();
    }

    public String InvalidLoginButtonClick(){
        driver.findElement(loginButton).click();
        return driver.findElement(loginLabel).getText();
    }
}
