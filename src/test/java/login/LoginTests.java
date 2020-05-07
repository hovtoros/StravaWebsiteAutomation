package login;

import base.BaseTests;
import constants.LoginFormConstants;
import org.testng.annotations.Test;
import pages.UserOnBoardingPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void SuccessfulLoginTest(){
        FillLoginForm(LoginFormConstants.validEmail, LoginFormConstants.validPassword);
        UserOnBoardingPage userOnBoardingPage = loginPage.SuccessfulLoginButtonClick();
        assertTrue(userOnBoardingPage.GetAthleteProfileBadgeText().contains("Hovhannes Torosyan"));
        assertTrue(userOnBoardingPage.GetUserNotificationsLabelText().contains("Notifications"));
    }

    @Test
    public void UnsuccessfulLoginInvalidEmailTest(){
        FillLoginForm(LoginFormConstants.invalidEmail, LoginFormConstants.validPassword);
        String loginLabelText = loginPage.InvalidLoginButtonClick();
        assertTrue(loginLabelText.contains("Log In"));
    }

    @Test
    public void UnsuccessfulLoginInvalidPasswordTest(){
        FillLoginForm(LoginFormConstants.validEmail, LoginFormConstants.invalidPassword);
        loginPage.UnsuccessfulLoginButtonClick();
        String errorMessage = loginPage.errorMessage;
        assertTrue(errorMessage.contains("The username or password did not match. Please try again."));
    }



}