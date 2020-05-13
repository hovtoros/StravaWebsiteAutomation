package pages;

import dtos.ManualTrainingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserDashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNotifications = By.id("notifications-button");
    private By userName = By.id("athlete-profile");
    private By userSettings = By.xpath("//ul[@class='options']//a[contains(text(),'Settings')]");
    private By addManualEntry = By.xpath("//li[@class='nav-item drop-down-menu upload-menu enabled']//li[2]//a[1]");
    private By activityFeedEntryCard = By.xpath("//div[@class='activity feed-entry card']");
    private By activityTitle = By.className("title-text");
    private By activityDescription = By.className("activity-body");
    private By activityDistance = By.xpath("//div[contains(text(),'Distance')]");
    private By activityTime = By.xpath("//div[contains(text(),'Time')]");
    private By followingSiblingB = By.xpath("following-sibling::b");

    public UserDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 7);
    }

    public String GetAthleteProfileBadgeText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(userName)).getText();
    }

    public String GetUserNotificationsLabelText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(userNotifications)).getText();
    }

    public UserProfilePage ClickUserProfileSettingsField() {
        WebElement userSettingsField = wait.until(ExpectedConditions.presenceOfElementLocated(userSettings));
        driver.get(userSettingsField.getAttribute("href"));

        return new UserProfilePage(driver);
    }

    public AddManualTrainingPage ClickAddManualEntryField(){
        WebElement userSettingsField = wait.until(ExpectedConditions.presenceOfElementLocated(addManualEntry));
        driver.get(userSettingsField.getAttribute("href"));

        return new AddManualTrainingPage(driver);
    }

    public ManualTrainingDetails GetLastTrainingDetails(){
        WebElement entry = driver.findElement(activityFeedEntryCard);
        var details = new ManualTrainingDetails();
        details.Title = entry.findElement(activityTitle).getText();
        details.Description = entry.findElement(activityDescription).getText();

        String distanceUnmatched = entry.findElement(activityDistance).findElement(followingSiblingB).getText();
        Pattern floatPattern = Pattern.compile("([0-9]+[.][0-9]+)");
        Matcher floatMatcher = floatPattern.matcher(distanceUnmatched);
        if(floatMatcher.find())
            details.Distance = Float.parseFloat(floatMatcher.group());

        String elapsedTimeUnmatched = entry.findElement(activityTime).findElement(followingSiblingB).getText();
        Pattern timePattern = Pattern.compile("\\d+");
        Matcher timeMatcher = timePattern.matcher(elapsedTimeUnmatched);
        String[] timeParts = new String[2];
        int i = 0;
        while (timeMatcher.find()) {
            timeParts[i] = timeMatcher.group();
            i++;
        }
        details.ElapsedTimeHours = Integer.parseInt(timeParts[0]);
        details.ElapsedTimeMinutes = Integer.parseInt(timeParts[1]);

        return details;
    }
}
