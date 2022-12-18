package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Appium {
    static Properties prop = new Properties();

    public static Appium appium() {
        return new Appium();
    }

    private static Properties loadProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/Appium.properties");
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
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