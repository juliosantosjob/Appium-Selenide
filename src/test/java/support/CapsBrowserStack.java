package support;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static support.GetSecrets.getSecrets;

public class CapsBrowserStack extends DriverFactory {
    static String URL_BS = "http://hub.browserstack.com/wd/hub";

    public static CapsBrowserStack capsBrowserStack() {
        return new CapsBrowserStack();
    }

    public void setCapabilitiesBrowserStack() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserstack.user", getSecrets().getUser());
        caps.setCapability("browserstack.key", getSecrets().getKey());
        caps.setCapability("app", "bs://" + getSecrets().getHash());
        caps.setCapability("device", getSecrets().getDevice());
        caps.setCapability("os_version", getSecrets().getVersion());

        driver = new AndroidDriver<MobileElement>(new URL(URL_BS), caps);
    }
}