package support;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

import static support.GetSecrets.getSecrets;

public class CapsBrowserStack extends BaseScreen {
    private static DesiredCapabilities caps = new DesiredCapabilities();

    public static DesiredCapabilities getCapabilitiesBrowserStack() throws MalformedURLException {
        caps.setCapability("browserstack.user", getSecrets().getUser());
        caps.setCapability("browserstack.key", getSecrets().getKey());
        caps.setCapability("app", "bs://" + getSecrets().getHash());
        caps.setCapability("device", getSecrets().getDevice());
        caps.setCapability("os_version", getSecrets().getVersion());
        return CapsBrowserStack.caps;
    }
}