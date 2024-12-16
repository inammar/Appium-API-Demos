package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class FirstScript {

    private AndroidDriver driver;

    // Method to navigate back to the main screen
    public void navigateBackToMainScreen() { driver.navigate().back(); }

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Initialize UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options();

        // Set the desired capabilities for the Api Demos app
        options.setPlatformName("Android");
        options.setDeviceName("a8979a97");  // Replace with your emulator or device name

        // Api Demos app package and activity
        options.setAppPackage("io.appium.android.apis");  // Package name of the app
        options.setAppActivity("io.appium.android.apis.ApiDemos");  // Main activity of the app

        // Initialize the AndroidDriver with the Appium server URL and options
        String appiumServerURL = "http://127.0.0.1:4723";
        driver = new AndroidDriver(new URL(appiumServerURL), options);
    }

    @Test
    public void clickAppTest() {

        // Locate the "App" element using accessibility ID
        WebElement appScreen = driver.findElement(AppiumBy.accessibilityId("App"));

        // Click on the "App" element
        appScreen.click();
        System.out.println("Clicked on the App screen successfully!");

        // Navigate back to the main screen
        navigateBackToMainScreen();
    }

    @Test
    public void clickButtonsTest() {
        // Locate the "Views" element using accessibility ID and click on it
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Locate the "Buttons" element using accessibility ID and click on it
        driver.findElement(AppiumBy.accessibilityId("Buttons")).click();

        // Locate the button OFF
        WebElement buttonOff = driver.findElement(AppiumBy.accessibilityId("Toggle"));

        // Perform click
        buttonOff.click();

        // Navigate back to the main screen
        navigateBackToMainScreen();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}