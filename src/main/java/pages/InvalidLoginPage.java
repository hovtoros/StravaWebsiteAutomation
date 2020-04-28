package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidLoginPage extends LoginPage {
    private By alertMessage;

    public InvalidLoginPage(WebDriver driver, By alertMessage) {
        super(driver);
        this.alertMessage = alertMessage;
    }

    public String GetAlertMessageText () {
        return driver.findElement(alertMessage).getText();
    }
}
