package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginReference = By.linkText("Log In");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage ClickLoginReference(){
        driver.findElement(loginReference).click();
        return new LoginPage(driver);
    }
}
