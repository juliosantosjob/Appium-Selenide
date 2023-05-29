package support;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

import static setup.Environments.getPlatform;
import static setup.Environments.getTools;
import static setup.Environments.getTimeout;
import static support.CapsAppium.setCapabilitiesAppium;
import static support.CapsBrowserStack.setCapabilitiesBrowserStack;

public class DriverFactory {
    public static AppiumDriver<MobileElement> driver;

    public static DriverFactory driverFactory() {
        return new DriverFactory();
    }

    public void setDriver() throws Exception {
        if (getPlatform().equals("Android") && getTools().equals("appium")) {
            setCapabilitiesAppium();
        } else if (getPlatform().equals("Android") && getTools().equals("bs")) {
            setCapabilitiesBrowserStack();
        } else {
            throw new IllegalArgumentException("Invalid execution argument!");
        }
        
        driver.manage().timeouts().implicitlyWait(getTimeout(), TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }
}