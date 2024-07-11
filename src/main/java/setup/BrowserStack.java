package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserStack {
    private static final String PATH_PROP = "/src/main/java/resources/browserStack.properties";
    private static final String PATH_PROJECT = System.getProperty("user.dir") + PATH_PROP;
    private static final Properties PROP = new Properties();

    public static BrowserStack browserStack() {
        return new BrowserStack();
    }

    private static Properties loadProperties() {
        try {
            PROP.load(new FileInputStream(PATH_PROJECT));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return BrowserStack.PROP;
    }

    public String getBrowserstackDevice() {
        return loadProperties().getProperty("BS_DEVICE");
    }

    public String getBrowserstackVersion() {
        return loadProperties().getProperty("BS_VERSION");
    }

    public String getBrowserstackUser() {
        return loadProperties().getProperty("BS_USER");
    }

    public String getBrowserstackKey() {
        return loadProperties().getProperty("BS_KEY");
    }

    public String getBrowserstackHash() {
        return loadProperties().getProperty("BS_HASH");
    }
}