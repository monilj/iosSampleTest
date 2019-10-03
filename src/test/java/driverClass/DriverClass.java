package driverClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverClass {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static IOSDriver<IOSElement> driver;

    //1
    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        //2
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        url = new URL(URL_STRING);

        //3
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
//        capabilities.setCapability(MobileCapabilityType.APP, "/Users/monilj/Desktop/app_ios/sampleApp.app");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/monilj/Desktop/app_ios/TestApp-iphonesimulator.app");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("useNewWDA", false);
        //4
        driver = new IOSDriver<IOSElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.resetApp();
        System.out.println("APP installed");
    }
    //5
    @AfterSuite
    public void uninstallApp() throws InterruptedException {
        driver.removeApp("com.bzytan.appiumeveryday");
    }
//    6
    @Test(enabled=true)
    public void myFirstTest() throws InterruptedException {
        driver.findElementByAccessibilityId("IntegerA").click();

    }
}
