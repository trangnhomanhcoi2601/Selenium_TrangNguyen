package page_objects;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TimetablePage extends BasePage {

    //Locators
    private String lnkCheckPrice = "//table[@class='MyTable WideTable']//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td/a[text()='check price']";
    private String lnkBookTicket = "//table[@class='MyTable WideTable']//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td/a[text()='book ticket']";

    //Elements
    private WebElement getLnkCheckPrice(String departStation, String arriveStation) {
        By checkPriceRow = By.xpath(String.format(lnkCheckPrice, departStation, arriveStation));
        return DriverHelper.getDriver().findElement(checkPriceRow);
    }

    private WebElement getLnkBookTicket(String departStation, String arriveStation) {
        By checkPriceRow = By.xpath(String.format(lnkBookTicket, departStation, arriveStation));
        return DriverHelper.getDriver().findElement(checkPriceRow);
    }

    //Methods
    public void clickCheckPriceLink(String departStation, String arriveStation) {
        getLnkCheckPrice(departStation, arriveStation).click();
    }

    public void clickBookTicketLink(String departStation, String arriveStation) {
        getLnkBookTicket(departStation, arriveStation).click();
    }
}