package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UserDashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNotifications = By.id("notifications-button");
    private By userName = By.id("athlete-profile");
    private By userSettings = By.xpath("//ul[@class='options']//a[contains(text(),'Settings')]");
    private By addManualEntry = By.xpath("//li[@class='nav-item drop-down-menu upload-menu enabled']//li[2]//a[1]");

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 3);
    }

    public String GetAthleteProfileBadgeText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(userName)).getText();
    }

    public String GetUserNotificationsLabelText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(userNotifications)).getText();
    }

    public UserProfilePage UserProfileSettingsFieldClick() {
        WebElement userSettingsField = wait.until(ExpectedConditions.presenceOfElementLocated(userSettings));
        driver.get(userSettingsField.getAttribute("href"));
        return new UserProfilePage(driver);
    }
}
