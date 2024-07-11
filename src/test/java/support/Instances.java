package support;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import static support.CapsBrowserStack.getCapabilitiesBrowserStack;
import static support.CapsAppium.getCapabilitiesAppium;

import static setup.Env.getPlatform;
import static setup.Env.getTools;

public class Instances {
    private final String URL_APPIUM = "http://localhost:4723/wd/hub";
    private final String URL_BS = "http://hub.browserstack.com/wd/hub";
    private final String platform = getPlatform().toUpperCase();
    private final String tools = getTools().toLowerCase();

    public AppiumDriver<MobileElement> getDriverInstance() throws MalformedURLException {
        if (platform.equals("ANDROID")) {
            switch (tools) {
                case "appium":
                    return new AppiumDriver<MobileElement>(new URL(URL_APPIUM), getCapabilitiesAppium());
                case "bs":
                    return new AppiumDriver<MobileElement>(new URL(URL_BS), getCapabilitiesBrowserStack());
                default:
                    throw new IllegalArgumentException("Invalid tools argument: " + tools);
            }
        } else {
            throw new IllegalArgumentException("Invalid platform argument: " + platform);
        }
    }
}
