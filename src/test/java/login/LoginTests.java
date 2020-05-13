package login;

import base.BaseTests;
import constants.LoginFormConstants;
import constants.UserProfileConstants;
import org.testng.annotations.Test;
import pages.UserDashboardPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void SuccessfulLoginTest(){
        UserDashboardPage userDashboardPage = LoginSuccessfully();

        assertTrue(userDashboardPage.GetAthleteProfileBadgeText().contains(UserProfileConstants.Name));
        assertTrue(userDashboardPage.GetUserNotificationsLabelText().equalsIgnoreCase(UserProfileConstants.NotificationsLabel));
    }

    @Test
    public void UnsuccessfulLoginInvalidEmailTest(){
        var loginPage = GoLoginPageAndFillForm(LoginFormConstants.InvalidEmail, LoginFormConstants.ValidPassword);
        String loginLabelText = loginPage.ClickInvalidLoginButton();

        assertTrue(loginLabelText.equalsIgnoreCase(LoginFormConstants.FormLabel));
    }

    @Test
    public void UnsuccessfulLoginInvalidPasswordTest(){
        var loginPage = GoLoginPageAndFillForm(LoginFormConstants.ValidEmail, LoginFormConstants.InvalidPassword);
        loginPage.ClickUnsuccessfulLoginButton();
        String errorMessage = loginPage.errorMessage;

        assertTrue(errorMessage.equalsIgnoreCase(LoginFormConstants.ErrorMessage));
    }
}