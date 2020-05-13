package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage {
    private WebDriver driver;
    private By dashBoard = By.xpath("//a[contains(text(),'Dashboard')]");

    public ActivityPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserDashboardPage ClickDashboardReference(){
        driver.get(driver.findElement(dashBoard).getAttribute("href"));

        return new UserDashboardPage(driver);
    }
}
