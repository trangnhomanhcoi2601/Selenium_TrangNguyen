package tests;

import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.ChangePasswordPage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ChangePasswordTests extends BaseTests {
    private LoginPage loginPage = new LoginPage();
    private BasePage basePage = new BasePage();
    private RegisterPage registerPage = new RegisterPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    private final String email = DataHelper.getRandomEmail();
    private final String password = DataHelper.getRandomPassword();
    private final String pid = DataHelper.getRandomNumber();
    private final String newPassword = "123456789";

    @BeforeMethod
    public void preCondition() {
        registerPage.goToRegisterTab();
        registerPage.register(email, password, password, pid);
        loginPage.goToLoginTab();
        loginPage.login(email, password);
    }

    @Test(description = "User can change password successfully. ")
    public void tc074_UserCanChangePassword(){
        LogHelper.info("Change password. ");
        changePasswordPage.goToChangePasswordTab();
        changePasswordPage.changePassword(password, newPassword, newPassword);

        Assert.assertEquals(changePasswordPage.getSuccessMessage(), "Your password has been updated!", "Success message doesn't display correctly. ");
        LogHelper.info("Login with new password. ");
        basePage.clickLogout();
        loginPage.goToLoginTab();
        loginPage.login(email, newPassword);
        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome to Safe Railway", "Welcome message doesn't display correctly.");
    }
}
