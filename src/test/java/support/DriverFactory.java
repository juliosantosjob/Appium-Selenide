package support;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

import static setup.Environments.envs;
import static support.CapsAppium.capsAppium;
import static support.CapsBrowserStack.capsBrowserStack;

public class DriverFactory {
    public static AppiumDriver<MobileElement> driver;

    public static DriverFactory driverFactory() {
        return new DriverFactory();
    }

    public void setDriver() throws Exception {
        if (envs().getPlatform().equals("Android") && envs().getTools().equals("appium")) {
            capsAppium().setCapabilitiesAppium();
        } else if (envs().getPlatform().equals("Android") && envs().getTools().equals("bs")) {
            capsBrowserStack().setCapabilitiesBrowserStack();
        } else {
            throw new IllegalArgumentException("Invalid execution argument!");
        }
        driver.manage().timeouts().implicitlyWait(envs().getTimeout(), TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }
}