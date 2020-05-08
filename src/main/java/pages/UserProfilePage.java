package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class UserProfilePage {
    private WebDriver driver;
    private By myAccountSection = By.xpath("//h3[contains(text(),'My Account')]");
    private By userEmailLabel = By.xpath("//div[@class='label']");
    private By userNameLabel = By.xpath("//div[contains(text(),'Name')]");
    private By userBirthdayLabel = By.xpath("//div[contains(text(),'Birthday')]");
    private By followingSiblingDiv = By.xpath("following-sibling::div");

    public UserProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private WebElement GetUserEmailLabelElement(){
        return driver.findElement(myAccountSection).findElement(userEmailLabel);
    }

    public String GetUserEmailLabelText(){
        return GetUserEmailLabelElement().getText();
    }

    public String GetUserEmail() {
        return GetUserEmailLabelElement().findElement(followingSiblingDiv).getText();
    }

    private WebElement GetUserNameLabelElement(){
        return driver.findElement(userNameLabel);
    }

    public String GetUserNameLabelText(){
        return GetUserNameLabelElement().getText();
    }

    public String GetUserName() {
        return GetUserNameLabelElement().findElement(followingSiblingDiv).getText();
    }

    private WebElement GetUserBirthdayLabelElement(){
        return driver.findElement(userBirthdayLabel);
    }

    public String GetUserBirthdayLabelText(){
        return GetUserBirthdayLabelElement().getText();
    }

    public String GetUserBirthday() {
        return GetUserBirthdayLabelElement().findElement(followingSiblingDiv).getText();
    }
}
