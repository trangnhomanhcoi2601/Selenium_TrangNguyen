package tests;

import common.Constants;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LoginPage;
import page_objects.TimetablePage;


public class TimetableTests extends BaseTests {
    private TimetablePage timetablePage = new TimetablePage();
    private LoginPage loginPage = new LoginPage();
    private String departStation = "Sài Gòn";
    private String arriveStation = "Phan Thiết";

    @Test(description = "User can navigate to Ticket price page by clicking on 'check price' link ")
    public void tc093_NavigateToTicketPricePageByClickingOnCheckPriceLink() {
        LogHelper.info("Click check price link. ");
        timetablePage.goToTimetableTab();
        timetablePage.clickCheckPriceLink(departStation, arriveStation);

        Assert.assertEquals(DriverHelper.getCurrentTitle(), "Safe Railway - Ticket Price", "Page doesn't navigate to Ticket Price Page.");
    }

    @Test(description = "User can navigate to Login page by clicking on 'book ticket' link when not logged in yet. ")
    public void tc094_NavigateToBookTicketLoginPageByClickingOnCheckPriceLink() {
        LogHelper.info("Click book ticket link. ");
        timetablePage.goToTimetableTab();
        timetablePage.clickBookTicketLink(departStation, arriveStation);

        Assert.assertEquals(DriverHelper.getCurrentTitle(), "Safe Railway - Login", "Page doesn't navigate to Login Page.");
    }

    @Test(description = "User can navigate to Book ticket page by clicking on 'book ticket' link when logged in already. ")
    public void tc095_NavigateToBookTicketLoginPageByClickingOnCheckPriceLink() {
        LogHelper.info("Login with valid info. ");
        loginPage.goToLoginTab();
        loginPage.login(Constants.USER, Constants.PASSWORD);
        LogHelper.info("Click book ticket link. ");
        timetablePage.goToTimetableTab();
        timetablePage.clickBookTicketLink(departStation, arriveStation);

        Assert.assertEquals(DriverHelper.getCurrentTitle(), "Safe Railway - Book Ticket", "Page doesn't navigate to Login Page.");
    }
}
