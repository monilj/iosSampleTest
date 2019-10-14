package testCases;

import Com.base.TestBase;
import Com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    HomePage homePage;
    public HomePageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        initilization();
        homePage=new HomePage();
    }

    @Test(priority = 1)
    public void checkSummationFunction() {
        homePage.additionFunction();

    }
    @Test(priority = 2)
    public void checkAlertFunction() {
        homePage.testAlert();

    }

}