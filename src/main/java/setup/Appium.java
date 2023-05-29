package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Appium {
    public static String Path = "/src/main/java/resources/appium.properties";
    public static String platformName;
    public static String deviceName;
    public static String app;
    public static Properties prop = new Properties();

    public static Appium appium() {
        return new Appium();
    }

    public static Properties loadProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + Path);
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public String getPlatformName() {
        return platformName = loadProperties().getProperty("platformName");
    }

    public String getDeviceName() {
        return deviceName = loadProperties().getProperty("deviceName");
    }

    public String getPathApk() {
        return app = loadProperties().getProperty("app");
    }
}