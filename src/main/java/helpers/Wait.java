package helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void untilElementIsVisible(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void untilElementIsSelected(WebElement element, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void untilElementToBeClickabe(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
