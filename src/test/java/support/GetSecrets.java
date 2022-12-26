package support;

import org.junit.Test;

import static setup.BrowserStack.browserStack;
import static setup.Environments.envs;

public class GetSecrets {
    private String getDevice = System.getenv("BS_DEVICE");
    private String getVersion = System.getenv("BS_VERSION");
    private String getUser = System.getenv("BS_USER");
    private String getKey = System.getenv("BS_KEY");
    private String getHash = System.getenv("BS_HASH");

    public static GetSecrets getSecrets() {
        return new GetSecrets();
    }

    public String getDevice() {
        if (getDevice == null) getDevice = browserStack().getBrowserstackDevice();
        return getDevice;
    }

    public String getVersion() {
        if (getVersion == null) getVersion = browserStack().getBrowserstackVersion();
        return getVersion;
    }

    public String getUser() {
        if (getUser == null) getUser = browserStack().getBrowserstackUser();
        return getUser;
    }

    public String getKey() {
        if (getKey == null) getKey = browserStack().getBrowserstackKey();
        return getKey;
    }

    public String getHash() {
        if (getHash == null) getHash = browserStack().getBrowserstackHash();
        return getHash;
    }
}