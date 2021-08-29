package tests;

import common.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LoginPage;

public class LogoutTests extends BaseTests {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Test(description = "User can log out successfully when clicking on Log out ")
    public void tc101_Logout(){
        loginPage.goToLoginTab();
        loginPage.login(Constants.USER, Constants.PASSWORD);
        basePage.clickLogout();

        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome to Safe Railway", "Welcome message doesn't correctly. ");
    }
}
