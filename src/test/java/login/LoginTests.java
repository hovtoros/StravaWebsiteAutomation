package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.UserOnBoardingPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void SuccessfulLoginTest(){
        loginPage.setEmail("hovhannes_torosyan@edu.aua.am");
        loginPage.setPassword("dummypass1234");
        UserOnBoardingPage userOnBoardingPage = loginPage.SuccessfulLoginButtonClick();
        assertTrue(userOnBoardingPage.GetAthleteProfileBadgeText().contains("Hovhannes Torosyan"));
    }

    @Test
    public void UnsuccessfulLoginInvalidEmailTest(){
        loginPage.setEmail("invalid");
        loginPage.setPassword("dummypass1234");
        String loginLabelText = loginPage.InvalidLoginButtonClick();
        assertTrue(loginLabelText.contains("Log In"));
    }

    @Test
    public void UnsuccessfulLoginInvalidPasswordTest(){
        loginPage.setEmail("hovhannes_torosyan@edu.aua.am");
        loginPage.setPassword("invalid");
        String alertMessage = loginPage.UnsuccessfulLoginButtonClick();
        assertTrue(alertMessage.contains("The username or password did not match. Please try again."));
    }



}