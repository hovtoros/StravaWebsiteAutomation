package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.UserOnBoardingPage;
import services.LoginFollowingPageDetector;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void SuccessfulLoginTest(){
        loginPage.setEmail("hovhannes_torosyan@edu.aua.am");
        loginPage.setPassword("dummypass1234");
        LoginFollowingPageDetector loginFollowingPageDetector = loginPage.clickLoginButton();
        loginFollowingPageDetector.Detect();
        UserOnBoardingPage userOnBoardingPage = loginFollowingPageDetector.UserOnBoardingPage;
        assertNotNull(userOnBoardingPage);
        assertTrue(userOnBoardingPage.GetAthleteProfileBadgeText().contains("Hovhannes Torosyan"));
    }

    @Test
    public void UnsuccessfulLoginInvalidEmailTest(){
        loginPage.setEmail("invalid");
        loginPage.setPassword("dummypass1234");
        LoginFollowingPageDetector loginFollowingPageDetector = loginPage.clickLoginButton();
        loginFollowingPageDetector.Detect();
        assertNotNull(loginFollowingPageDetector);
        assertTrue(loginFollowingPageDetector.LoginPage.GetLoginLabelText().contains("Log In"));
    }

    @Test
    public void UnsuccessfulLoginInvalidPasswordTest(){
        loginPage.setEmail("hovhannes_torosyan@edu.aua.am");
        loginPage.setPassword("invalid");
        LoginFollowingPageDetector loginFollowingPageDetector = loginPage.clickLoginButton();
        loginFollowingPageDetector.Detect();
        assertNotNull(loginFollowingPageDetector);
        assertTrue(loginFollowingPageDetector.InvalidLoginPage.GetAlertMessageText().contains("The username or password did not match. Please try again."));
    }



}