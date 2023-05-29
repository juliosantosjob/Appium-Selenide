package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static setup.Appium.appium;

public class CapsAppium extends DriverFactory {
    static String URL_APPIUM = "http://localhost:4723/wd/hub";

    public static void setCapabilitiesAppium() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:app", new File(appium().getPathApk()).getAbsolutePath());
        caps.setCapability("appium:platformName", appium().getPlatformName());
        caps.setCapability("appium:deviceName", appium().getDeviceName());

        driver = new AppiumDriver<MobileElement>(new URL(URL_APPIUM), caps);
    }
}