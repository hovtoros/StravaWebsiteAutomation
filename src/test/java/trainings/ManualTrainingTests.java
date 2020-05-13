package trainings;

import base.BaseTests;
import dtos.ManualTrainingDetails;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ManualTrainingTests extends BaseTests {
    @Test
    public void AddManualTrainingSuccessfullyUserDashboardTest(){
        var details = new ManualTrainingDetails();
        details.Title = "Test Training";
        details.Description = "Sample Description";
        details.Distance = (float)72.45;
        details.ElapsedTimeHours = 5;
        details.ElapsedTimeMinutes = 23;

        var userDashboardPage = LoginSuccessfully();
        var addManualEntryPage = userDashboardPage.ClickAddManualEntryField();
        addManualEntryPage.setManualTraining(details);
        var activityPage = addManualEntryPage.ClickCreateButton();
        userDashboardPage = activityPage.ClickDashboardReference();
        var resultedDetails = userDashboardPage.GetLastTrainingDetails();

        assertEquals(resultedDetails.Title, details.Title);
        assertEquals(resultedDetails.Description, details.Description);
        assertEquals(resultedDetails.Distance, details.Distance);
        assertEquals(resultedDetails.ElapsedTimeHours, details.ElapsedTimeHours);
        assertEquals(resultedDetails.ElapsedTimeMinutes, details.ElapsedTimeMinutes);
    }
}
