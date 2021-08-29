package page_objects;

import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.*;


public class RegisterPage extends BasePage {

    //Locators
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("password");
    private By txtConfirmPassword = By.id("confirmPassword");
    private By txtPid = By.id("pid");
    private By btnRegister = By.cssSelector("input[type='submit']");
    private By lblSuccessMessage = By.cssSelector("#content p");
    private By lblErrorMessage = By.cssSelector("#content>p[class = 'message error']");
    private By lnkLogin = By.cssSelector("div a[href='/Account/Login.cshtml']");
    private By lblErrorEmailMessage = By.cssSelector(".email>label[class='validation-error']");
    private By lblErrorPasswordMessage = By.cssSelector(".password>label[class='validation-error']");
    private By lblErrorPidMessage = By.cssSelector(".pid-number>label[class='validation-error']");

    //Elements
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }

    private WebElement getTxtPid() {
        return DriverHelper.getDriver().findElement(txtPid);
    }

    private WebElement getBtnRegister() {
        return DriverHelper.getDriver().findElement(btnRegister);
    }

    private WebElement getLinkLogin() {
        return DriverHelper.getDriver().findElement(lnkLogin);
    }

    //Methods
    public String getSuccessMessage() {
        return DriverHelper.getDriver().findElement(lblSuccessMessage).getText();
    }

    public String getErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage).getText();
    }

    public String getErrorEmailMessage() {
        return DriverHelper.getDriver().findElement(lblErrorEmailMessage).getText();
    }

    public String getErrorPasswordMessage() {
        return DriverHelper.getDriver().findElement(lblErrorPasswordMessage).getText();
    }

    public String getErrorPidMessage() {
        return DriverHelper.getDriver().findElement(lblErrorPidMessage).getText();
    }

    public void clickRegisterButton() {
        ElementHelper.scrollToView(getBtnRegister());
        getBtnRegister().click();
    }

    public void clickLoginLink() {
        getLinkLogin().click();
    }

    public void register(String email, String password, String confirmPassword, String Pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPid().sendKeys(Pid);
        clickRegisterButton();
    }
}






