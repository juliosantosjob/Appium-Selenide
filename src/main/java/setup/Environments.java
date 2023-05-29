package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Environments {
    static Properties prop = new Properties();

    private static Properties loadProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/environments.properties");
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static String getPlatform() {
        return loadProperties().getProperty("platform");
    }

    public static String getTools() {
        return loadProperties().getProperty("tools");
    }

    public static Long getTimeout() {
        return Long.valueOf(loadProperties().getProperty("timeout"));
    }
}