package tests;

import helpers.DataHelper;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.RegisterPage;


public class RegisterTests extends BaseTests {

    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid  = DataHelper.getRandomNumber();
    private final String invalidPid = "Thisaretexts";

    @BeforeMethod
    public void preCondition() {
        registerPage.goToRegisterTab();
    }

    @Test(description = "User can register an account with valid info")
    public void tc017_RegisterWithValidData() {
        LogHelper.info("Enter register information. ");
        registerPage.register(email, password, password, pid);

        Assert.assertEquals(registerPage.getSuccessMessage(), "You're here", "The successful message doesn't display correctly. ");

        loginPage.goToLoginTab();
        loginPage.login(email, password);
    }

    @Test(description = "User can navigate to Login page by clicking on 'Login' hyperlink when not logged in yet")
    public void tc018_NavigateToLoginPageByClickingLoginLink() {
        LogHelper.info("Click on login link. ");
        registerPage.clickLoginLink();

        Assert.assertEquals(DriverHelper.getCurrentTitle(), "Safe Railway - Login", "Page doesn't navigate to Login page.");
    }

    @Test(description = "User cannot register an account in case don't enter data into all the fields")
    public void tc022_RegisterWithLeavingAllFieldsBlank() {
        LogHelper.info("Don't enter any information into all fields. ");
        registerPage.register("", "", "", "");

        Assert.assertEquals(registerPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.", "Error message doesn't display correctly. ");
        Assert.assertEquals(registerPage.getErrorEmailMessage(), "Invalid email length", "Error email message doesn't display correctly. ");
        Assert.assertEquals(registerPage.getErrorPasswordMessage(), "Invalid password length", "Error password message doesn't display correctly. ");
        Assert.assertEquals(registerPage.getErrorPidMessage(), "Invalid ID length", "Error Pid message doesn't display correctly. ");
    }

    @Test (description = "User cannot register an account when inputting text into 'PID/Passport number' filed")
    public void tc033_RegisterWithInputtingTextIntoPidNumberField(){
        registerPage.register(email, password, password, invalidPid);

        Assert.assertEquals(registerPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.", "Error message doesn't display correctly. ");
        Assert.assertEquals(registerPage.getErrorPidMessage(), "Invalid ID length", "Error Pid message doesn't display correctly. ");
    }
}

