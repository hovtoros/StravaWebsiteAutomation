package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserOnBoardingPage {
    private WebDriver driver;
    private By userNotificationsCount = By.id("notifications-count");
    private By userName = By.id("athlete-profile");

    public UserOnBoardingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String GetAthleteProfileBadgeText() {
        return driver.findElement(userName).getText();
    }

    public int GetUserNotificationsCount() {
        return Integer.parseInt(driver.findElement(userNotificationsCount).getText());
    }
}
