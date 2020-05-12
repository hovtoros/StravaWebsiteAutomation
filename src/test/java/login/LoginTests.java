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
        assertTrue(userDashboardPage.GetUserNotificationsLabelText().equalsIgnoreCase("notifications"));
    }

    @Test
    public void UnsuccessfulLoginInvalidEmailTest(){
        var loginPage = GoLoginPageAndFillForm(LoginFormConstants.invalidEmail, LoginFormConstants.validPassword);
        String loginLabelText = loginPage.InvalidLoginButtonClick();
        assertTrue(loginLabelText.contains("Log In"));
    }

    @Test
    public void UnsuccessfulLoginInvalidPasswordTest(){
        var loginPage = GoLoginPageAndFillForm(LoginFormConstants.validEmail, LoginFormConstants.invalidPassword);
        loginPage.UnsuccessfulLoginButtonClick();
        String errorMessage = loginPage.errorMessage;
        assertTrue(errorMessage.contains("The username or password did not match. Please try again."));
    }



}