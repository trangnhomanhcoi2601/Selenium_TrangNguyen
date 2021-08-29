package page_objects;


import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //Locators
    private final By tabLogin = By.cssSelector("li a[href='/Account/Login.cshtml']");
    private final By tabRegister = By.cssSelector("li a[href='/Account/Register.cshtml']");
    private final By tabTimetable = By.cssSelector("li a[href='TrainTimeListPage.cshtml']");
    private final By tabBookticket = By.cssSelector("li a[href='/Page/BookTicketPage.cshtml']");
    private final By tabMyticket = By.cssSelector("li a[href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.cssSelector("li a[href='/Account/ChangePassword.cshtml']");
    private final By Logout = By.cssSelector("li a[href='/Account/Logout']");


    //Elements
    private WebElement getLoginTab() {
        return DriverHelper.getDriver().findElement(tabLogin);
    }

    private WebElement getRegisterTab() {
        return DriverHelper.getDriver().findElement(tabRegister);
    }

    private WebElement getTimetableTab() {
        return DriverHelper.getDriver().findElement(tabTimetable);
    }

    private WebElement getBookticketTab() {
        return DriverHelper.getDriver().findElement(tabBookticket);
    }

    private WebElement getMyticketTab() {
        return DriverHelper.getDriver().findElement(tabMyticket);
    }

    private WebElement getChangePasswordTab() {return DriverHelper.getDriver().findElement(tabChangePassword);}

    private WebElement getLogout() { return DriverHelper.getDriver().findElement(Logout);}

    //Methods
    public void goToLoginTab() {
        getLoginTab().click();
    }

    public void goToRegisterTab() {
        getRegisterTab().click();
    }

    public void goToTimetableTab() {
        getTimetableTab().click();
    }

    public void goToBookticketTab() {
        getBookticketTab().click();
    }

    public void goToMyticketTab() {
        getMyticketTab().click();
    }

    public void goToChangePasswordTab(){ getChangePasswordTab().click();}

    public void clickLogout(){ getLogout().click();}
}
