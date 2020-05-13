package profile;

import base.BaseTests;
import constants.LoginFormConstants;
import constants.UserProfileConstants;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class UserProfileTests extends BaseTests {
    @Test
    public void UserProfileInformationTest(){
        var userDashboardPage = LoginSuccessfully();
        var userProfilePage = userDashboardPage.ClickUserProfileSettingsField();

        assertTrue(userProfilePage.GetUserEmailLabelText().equalsIgnoreCase("Email"));
        assertTrue(userProfilePage.GetUserEmail().equalsIgnoreCase(LoginFormConstants.ValidEmail));
        assertTrue(userProfilePage.GetUserNameLabelText().equalsIgnoreCase("Name"));
        assertTrue(userProfilePage.GetUserName().equalsIgnoreCase(UserProfileConstants.Name));
        assertTrue(userProfilePage.GetUserBirthdayLabelText().equalsIgnoreCase("Birthday"));
        assertTrue(userProfilePage.GetUserBirthday().equalsIgnoreCase(UserProfileConstants.Birthday));
    }
}
