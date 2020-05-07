package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserOnBoardingPage {
    private WebDriver driver;
    private By userNotificationsButton = By.id("notifications-button");
    private By userName = By.id("athlete-profile");

    public UserOnBoardingPage(WebDriver driver) {
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
}
