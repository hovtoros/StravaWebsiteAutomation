package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserDashboardPage {
    private WebDriver driver;
    private By userNotificationsButton = By.id("notifications-button");
    private By userName = By.id("athlete-profile");
    private By userSettings = By.xpath("//ul[@class='options']//a[contains(text(),'Settings')]");

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetAthleteProfileBadgeText() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(userName)).getText();
    }

    public String GetUserNotificationsLabelText() {
        return new WebDriverWait(driver, 5 )
                .until(ExpectedConditions.elementToBeClickable(userNotificationsButton)).getText();
    }

    public UserProfilePage UserProfileSettingsFieldClick() {
        WebElement userSettingsField = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(userSettings));
        driver.get(userSettingsField.getAttribute("href"));
        return new UserProfilePage(driver);
    }
}
