package page_objects;


import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import helpers.DriverHelper;
import helpers.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {

    //Locators
    private By txtUsername = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.cssSelector(".form-actions input[value='Login']");
    private By lblWelcomeMessage = By.cssSelector("div[id=content]>h1");
    private By lnkRegisterPage = By.cssSelector("li a[href='Register.cshtml']");
    private By lnkForgotPasswordPage = By.cssSelector("li a[href='/Account/ForgotPassword.cshtml']");
    private By lblErrorLoginMessage = By.cssSelector("div p[class='message error LoginForm']");
    private By lblErrorEmailMessage = By.cssSelector(".username [class = 'validation-error']");
    private By lblErrorPasswordMessage = By.cssSelector(".password [class = 'validation-error']");
    private By frmPasswordReset = By.xpath("//legend[contains(text(),'Password Reset Instructions Form')]");

    //Elements
    private WebElement getTxtUsername() {
        return DriverHelper.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }

    private WebElement getLblWelcomeMessage() {
        return DriverHelper.getDriver().findElement(lblWelcomeMessage);
    }

    private WebElement getLnkRegisterPage() {
        return DriverHelper.getDriver().findElement(lnkRegisterPage);
    }

    private WebElement getLnkForgotPasswordPage() { return DriverHelper.getDriver().findElement(lnkForgotPasswordPage);}

    private WebElement getLblErrorLoginMessage() {
        return DriverHelper.getDriver().findElement(lblErrorLoginMessage);
    }

    private WebElement getLblErrorEmailMessage() {
        return DriverHelper.getDriver().findElement(lblErrorEmailMessage);
    }

    private WebElement getLblErrorPasswordMessage() { return DriverHelper.getDriver().findElement(lblErrorPasswordMessage);}

    private WebElement getFrmPasswordReset() { return DriverHelper.getDriver().findElement(frmPasswordReset);}


    //Methods
    public String getWelcomeMessage() {
        return getLblWelcomeMessage().getText();
    }

    public String getErrorLoginMessage() {
        return getLblErrorLoginMessage().getText();
    }

    public String getErrorEmailMessage() {
        return getLblErrorEmailMessage().getText();
    }

    public String getErrorPasswordMessage() {
        return getLblErrorPasswordMessage().getText();
    }

    public void clickRegisterPageLink() {
        getLnkRegisterPage().click();
    }

    public void clickForgotPasswordLink() {
        getLnkForgotPasswordPage().click();
    }

    public boolean doesPasswordResertDisplay() { return ElementHelper.isElementDisplayed(getFrmPasswordReset());}

    public void login(String user, String password) {
        getTxtUsername().sendKeys(user);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }
}
