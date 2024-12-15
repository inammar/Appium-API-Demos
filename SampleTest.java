package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Initialize UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options();

        // Set the desired capabilities for the Api Demos app
        options.setPlatformName("Android");
        options.setDeviceName("a8469a28");  // Replace with your emulator or device name

        // Api Demos app package and activity
        options.setAppPackage("io.appium.android.apis");  // Package name of the app
        options.setAppActivity("io.appium.android.apis.ApiDemos");  // Main activity of the app

        // Initialize the AndroidDriver with the Appium server URL and options
        String appiumServerURL = "http://127.0.0.1:4723";
        driver = new AndroidDriver(new URL(appiumServerURL), options);

    }

    @Test
    public void openAppTest() {

        // This method will only open the app and not perform any interactions
        System.out.println("Api demos app opened successfully!");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}