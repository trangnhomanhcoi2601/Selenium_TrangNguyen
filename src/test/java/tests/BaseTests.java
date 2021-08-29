package tests;

import helpers.DriverHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    @BeforeMethod
    public void setUp() {
        DriverHelper.initDriver();
        DriverHelper.navigate();
    }

    @AfterMethod
    public void tearDown() {
        DriverHelper.quit();
    }

}
