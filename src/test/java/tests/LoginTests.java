package tests;

import common.Constants;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.*;
import page_objects.LoginPage;


public class LoginTests extends BaseTests {

    private LoginPage loginPage = new LoginPage();
    public final String invalidEmail = "autotest@gmail.";
    public final String invalidPassword = "wrong password";



    @BeforeMethod
    public void preCondition() {
        loginPage.goToLoginTab();
    }


    @Test(description = "User can login successfully with valid email and valid password")
    public void tc040_LoginWithValidData() {
        LogHelper.info("Enter login information. ");
        loginPage.login(Constants.USER, Constants.PASSWORD);

        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome to Safe Railway", "Welcome message doesn't display correctly.");
    }

    @Test(description = "User can navigate to Register page by clicking on 'registration page' hyperlink when not logged in yet")
    public void tc041_GoToRegisterPageWhenUserNotLoginByClickingRegisterLink() {
        LogHelper.info("Click on register page link. ");
        loginPage.clickRegisterPageLink();

        Assert.assertEquals(DriverHelper.getCurrentTitle(), "Safe Railway - Register an Account", "Page doesn't navigate to Register page. ");
    }

    @Test(description = "The Password Reset Instructions Form is displayed when user clicking on 'Forgot Password page' when not logged in yet")
    public void tc042_PasswordResetInstructionsDisplays() {
        LogHelper.info("Click on forgot password link. ");
        loginPage.clickForgotPasswordLink();

        Assert.assertTrue(loginPage.doesPasswordResertDisplay(), "Password Reset Instructions Form doesn't display. ");
    }

    @Test(description = "User cannot login with invalid email and invalid password")
    public void tc044_LoginWithInvalidInfo() {
        LogHelper.info("Enter invalid login information. ");
        loginPage.login(invalidEmail, invalidPassword);

        Assert.assertEquals(loginPage.getErrorLoginMessage(), "Invalid username or password. Please try again.", "Error message doesn't display correctly.");
    }

    @Test(description = "User cannot login in case don't enter data into all the fields")
    public void tc045_LoginWithAllFieldsBlank() {
        LogHelper.info("Leave all fields blank. ");
        loginPage.login("", "");

        Assert.assertEquals(loginPage.getErrorEmailMessage(), "You must specify a username.", "Error email message doesn't display correctly.");
        Assert.assertEquals(loginPage.getErrorPasswordMessage(), "You must specify a password.", "Error password message doesn't display correctly.");
    }

    @Test(description = "User cannot login successfully in case don't enter data into 'Email' filed")
    public void tc046_LoginWithoutInputtingEmail() {
        LogHelper.info("Don't enter user name. Only enter password. ");
        loginPage.login("", Constants.PASSWORD);

        Assert.assertEquals(loginPage.getErrorEmailMessage(), "You must specify a username.", "Error email message doesn't display correctly.");
        Assert.assertEquals(loginPage.getErrorLoginMessage(), "There was a problem with your login and/or errors exist in your form.", "Error message doesn't display correctly.");
    }

}
