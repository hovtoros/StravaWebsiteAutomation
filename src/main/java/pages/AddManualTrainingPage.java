package pages;

import dtos.ManualTrainingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddManualTrainingPage {
    private WebDriver driver;
    private By distance = By.id("activity_distance");
    private By elapsedTimeHours = By.id("activity_elapsed_time_hours");
    private By elapsedTimeMinutes = By.id("activity_elapsed_time_minutes");
    private By elapsedTimeSeconds = By.id("activity_elapsed_time_seconds");
    private By elevationGain = By.id("activity_elev_gain");
    private By startDate = By.id("activity_start_date");
    private By startTimeOfDay = By.id("activity_start_time_of_day");
    private By title = By.id("activity_name");
    private By description = By.id("activity_description");
    private By create = By.xpath("//input[@class='btn-primary' and @value='Create']");

    public AddManualTrainingPage(WebDriver driver){
        this.driver = driver;
    }

    private void setDistance(Float value){
        driver.findElement(distance).sendKeys(String.valueOf(value));
    }

    private void setElapsedTimeHours(Integer value){
        var elapsedTimeHoursElement = driver.findElement(elapsedTimeHours);
        elapsedTimeHoursElement.clear();
        elapsedTimeHoursElement.sendKeys(String.valueOf(value));
    }

    private void setElapsedTimeMinutes(Integer value){
        var elapsedTimeMinutesElement = driver.findElement(elapsedTimeMinutes);
        elapsedTimeMinutesElement.clear();
        elapsedTimeMinutesElement.sendKeys(String.valueOf(value));
    }

    private void setElapsedTimeSeconds(Integer value){
        var elapsedTimeSecondsElement = driver.findElement(elapsedTimeSeconds);
        elapsedTimeSecondsElement.clear();
        elapsedTimeSecondsElement.sendKeys(String.valueOf(value));
    }

    private void setElevationGain(Float value){
        driver.findElement(elevationGain).sendKeys(String.valueOf(value));
    }

    private void setStartDate(String value){
        driver.findElement(startDate).sendKeys(value);
    }

    private void setStartTimeOfDay(String value){
        driver.findElement(startTimeOfDay).sendKeys(value);
    }

    public void setTitle(String value){
        var titleElement = driver.findElement(title);
        titleElement.clear();
        titleElement.sendKeys(value);
    }

    private void setDescription(String value){
        driver.findElement(description).sendKeys(value);
    }

    public void setManualTraining(ManualTrainingDetails details){
        if (details.Distance != null)
            setDistance(details.Distance);
        if (details.ElapsedTimeHours != null)
        setElapsedTimeHours(details.ElapsedTimeHours);
        if (details.ElapsedTimeMinutes != null)
            setElapsedTimeMinutes(details.ElapsedTimeMinutes);
        if (details.ElapsedTimeSeconds != null)
            setElapsedTimeSeconds(details.ElapsedTimeSeconds);
        if (details.ElevationGain != null)
            setElevationGain(details.ElevationGain);
        if (details.StartDate != null)
            setStartDate(details.StartDate);
        if (details.StartTimeOfDay != null)
            setStartTimeOfDay(details.StartTimeOfDay);
        if (details.Title != null)
            setTitle(details.Title);
        if (details.Description != null)
            setDescription(details.Description);
    }

    public ActivityPage ClickCreateButton(){
        driver.findElement(create).click();

        return new ActivityPage(driver);
    }
}
