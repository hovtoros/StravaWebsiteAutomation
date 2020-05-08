package login;

import base.BaseTests;
import constants.UserProfileConstants;
import org.testng.annotations.Test;
import pages.UserDashboardPage;

import static org.testng.Assert.assertTrue;

public class UserProfileTests extends BaseTests {
    @Test
    public void UserProfileInformationTest(){
        UserDashboardPage userDashboardPage = LoginSuccessfully();
        var userProfilePage = userDashboardPage.UserProfileSettingsFieldClick();
        assertTrue(userProfilePage.GetUserEmailLabelText().equalsIgnoreCase("Email"));
        assertTrue(userProfilePage.GetUserEmail().equalsIgnoreCase(UserProfileConstants.Email));
        assertTrue(userProfilePage.GetUserNameLabelText().equalsIgnoreCase("Name"));
        assertTrue(userProfilePage.GetUserName().equalsIgnoreCase(UserProfileConstants.Name));
        assertTrue(userProfilePage.GetUserBirthdayLabelText().equalsIgnoreCase("Birthday"));
        assertTrue(userProfilePage.GetUserBirthday().equalsIgnoreCase(UserProfileConstants.Birthday));
    }
}
