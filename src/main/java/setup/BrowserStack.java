package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BrowserStack {
    static Properties prop = new Properties();

    public static BrowserStack browserStack() {
        return new BrowserStack();
    }

    private static Properties loadProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/browserStack.properties");
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
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