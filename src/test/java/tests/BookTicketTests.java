package tests;

import common.Constants;
import common.Ticket;
import helpers.DateHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.LoginPage;

import java.util.ArrayList;
import java.util.List;


public class BookTicketTests extends BaseTests {
    private BookTicketPage bookticketPage = new BookTicketPage();
    private LoginPage loginPage = new LoginPage();

    private final String departFrom = "Sài Gòn";
    private final String arriveAt = "Huế";
    private final String seatType = "Soft bed";
    private final String ticketAmount = "1";
    private final String successfulMessage = "Ticket Booked Successfully!";

    @BeforeMethod
    public void preCondition() {
        loginPage.goToLoginTab();
        loginPage.login(Constants.USER, Constants.PASSWORD);
        bookticketPage.goToBookticketTab();
    }

    @Test(description = "User can book a ticket with default data from Book ticket form. ")
    public void tc052_BooksTicketWithDefaultValue() {
        LogHelper.info("Click on book ticket button. ");
        bookticketPage.clickBookticketButton();

        Assert.assertEquals(bookticketPage.getBookTicketMessage(), successfulMessage, "Message doesn't display correctly. ");
    }

    @Test(description = "User can book a ticket by selecting valid data from Book ticket form. ")
    public void tc053_BooksTicket() {
        LogHelper.info("Books a ticket. ");

        Ticket ticket = new Ticket();
        ticket.setDepartDate(DateHelper.getDayFromToday(Constants.ADD_DAY));
        ticket.setDepartFrom(departFrom);
        ticket.setArriveAt(arriveAt);
        ticket.setSeatType(seatType);
        ticket.setTicketAmount(ticketAmount);

        bookticketPage.bookTicket(ticket);

        Assert.assertEquals(bookticketPage.getBookTicketMessage(), successfulMessage, "Message doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(departFrom), "Depart station doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(arriveAt), "Arrive station doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(seatType), "Seat type doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(DateHelper.getDayFromToday(Constants.ADD_DAY)), "Depart Date doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(DateHelper.getCurrentDay()), "Book date doesn't display correctly. ");
        Assert.assertTrue(bookticketPage.getInfoTicketBookedSuccessfully().contains(ticketAmount), "Amount ticket doesn't display correctly. ");
    }

    @Test(description = "Ticket Amount dropdown contain values from 1 to 10")
    public void tc054_CheckTotalOfTicketAmount() {
        LogHelper.info("Creat a list amount contain values from 1 to 10");
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1");
        expectedResult.add("2");
        expectedResult.add("3");
        expectedResult.add("4");
        expectedResult.add("5");
        expectedResult.add("6");
        expectedResult.add("7");
        expectedResult.add("8");
        expectedResult.add("9");
        expectedResult.add("10");
        System.out.println(expectedResult);

        Assert.assertEquals(bookticketPage.getTotalTicketAmount(), expectedResult);
    }
}
