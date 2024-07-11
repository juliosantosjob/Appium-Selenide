package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Appium {
    private static final String PATH_PROP = "/src/main/java/resources/appium.properties";
    private static final String PATH_PROJECT = System.getProperty("user.dir") + PATH_PROP;
    private static final Properties PROP = new Properties();

    public static Appium appium() {
        return new Appium();
    }

    private static Properties loadProperties() {
        try {
            PROP.load(new FileInputStream(PATH_PROJECT));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Appium.PROP;
    }

    public String getPlatformName() {
        return loadProperties().getProperty("platformName");
    }

    public String getDeviceName() {
        return loadProperties().getProperty("deviceName");
    }

    public String getPathApk() {
        return loadProperties().getProperty("app");
    }
}