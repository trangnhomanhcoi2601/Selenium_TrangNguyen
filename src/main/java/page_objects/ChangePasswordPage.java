package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage{
    //Locators
    private By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private By lblSuccessMessage = By.xpath("//p[@class='message success']");

    //Elements
    private WebElement getTxtCurrentPassword() {
        return DriverHelper.getDriver().findElement(txtCurrentPassword);
    }

    private WebElement getTxtNewPassword() {
        return DriverHelper.getDriver().findElement(txtNewPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getBtnChangePassword() {
        return DriverHelper.getDriver().findElement(btnChangePassword);
    }

    private WebElement getLblSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblSuccessMessage);
    }

    //Methods
    public String getSuccessMessage(){return getLblSuccessMessage().getText();}

    public void changePassword(String currentPassword, String newPassword, String confirmPassword){
        ElementHelper.scrollToView(getBtnChangePassword());
        getTxtCurrentPassword().sendKeys(currentPassword);
        getTxtNewPassword().sendKeys(newPassword);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getBtnChangePassword().click();
    }
}
