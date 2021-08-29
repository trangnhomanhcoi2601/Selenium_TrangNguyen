package page_objects;

import common.Ticket;
import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class BookTicketPage extends BasePage {
    //Locators
    private By drpDepartDate = By.cssSelector("select[name = 'Date']");
    private By drpDepartFrom = By.cssSelector("select[name = 'DepartStation']");
    private By drpArriveAt = By.cssSelector("select[name='ArriveStation']");
    private By drpSeatType = By.cssSelector("select[name = 'SeatType']");
    private By drpTicketAmount = By.cssSelector("select[name = 'TicketAmount']");
    private By btnBookticket = By.cssSelector("input[value='Book ticket']");
    private By lblBookTicketMessage = By.cssSelector("#content>h1[align = 'center']");
    private By drpDate = By.xpath("//select[@name='TicketAmount']");
    private By lstTicketBookedSuccessfully = By.xpath("//table[@class='MyTable WideTable']/tbody/tr[2]/td");


    //Elements
    private WebElement getlblBookTicketMessage() {
        return DriverHelper.getDriver().findElement(lblBookTicketMessage);
    }

    private Select getDrpDepartDate() {
        return new Select(DriverHelper.getDriver().findElement(drpDepartDate));
    }

    private Select getDrpDepartFrom() { return new Select(DriverHelper.getDriver().findElement(drpDepartFrom));}

    private Select getDrpArriveAt() {
        return new Select(DriverHelper.getDriver().findElement(drpArriveAt));
    }

    private Select getDrpSeatType() {
        return new Select(DriverHelper.getDriver().findElement(drpSeatType));
    }

    private Select getDrpTicketAmount() {
        return new Select(DriverHelper.getDriver().findElement(drpTicketAmount));
    }

    private WebElement getBtnBookticket() {
        return DriverHelper.getDriver().findElement(btnBookticket);
    }

    private Select getdrpDate() { return new Select(DriverHelper.getDriver().findElement(drpDate));}


    //Methods

    public String getBookTicketMessage() {
        return getlblBookTicketMessage().getText();
    }

    public void selectDepartDate(String date) {
        getDrpDepartDate().selectByVisibleText(date);
    }

    public void selectDepartFrom(String departStation) {
        getDrpDepartFrom().selectByVisibleText(departStation);
    }

    public void selectArriveAt(String arriveStation) {
        getDrpArriveAt().selectByVisibleText(arriveStation);
    }

    public void selectSeatType(String seatType) { getDrpSeatType().selectByVisibleText(seatType);}

    public void selectTicketAmount(String ticketAmount) { getDrpTicketAmount().selectByVisibleText(ticketAmount);}

    public void clickBookticketButton() {
        ElementHelper.scrollToView(getBtnBookticket());
        getBtnBookticket().click();
    }

    public void bookTicket(Ticket ticket) {
        ElementHelper.scrollToView(this.getBtnBookticket());
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartFrom(ticket.getDepartFrom());
        this.selectArriveAt(ticket.getArriveAt());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        this.getBtnBookticket().click();
    }

    public List getTotalTicketAmount() {
        List<WebElement> originalListElements = getdrpDate().getOptions();
        List<String> originalList = new ArrayList<>();
        for (WebElement webElement : originalListElements) {
            originalList.add(webElement.getText());
        }
        return originalList;
    }

    public List getInfoTicketBookedSuccessfully() {
        List<String> ls = new ArrayList<>();
        List<WebElement> rowSize = DriverHelper.getDriver().findElements(lstTicketBookedSuccessfully);
        for (int i = 0; i < rowSize.size(); i++) {
            ls.add(rowSize.get(i).getText());
        }
        return ls;
    }
}






