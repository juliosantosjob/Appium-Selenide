package support;

import org.openqa.selenium.remote.DesiredCapabilities;

import static setup.Appium.appium;

import java.io.File;
import java.net.MalformedURLException;

public class CapsAppium extends BaseScreen {
    public static DesiredCapabilities caps = new DesiredCapabilities();

    public static DesiredCapabilities getCapabilitiesAppium() throws MalformedURLException {
        caps.setCapability("appium:app", new File(appium().getPathApk()).getAbsolutePath());
        caps.setCapability("appium:platformName", appium().getPlatformName());
        caps.setCapability("appium:deviceName", appium().getDeviceName());
        return CapsAppium.caps;
    }
}