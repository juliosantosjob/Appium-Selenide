package setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Environments {
    static Properties prop = new Properties();

    public static Environments envs() {
        return new Environments();
    }

    private static Properties loadProperties() {
        try {
            InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/Environments.properties");
            prop.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public String getPlatform() {
        return loadProperties().getProperty("platform");
    }

    public String getTools() {
        return loadProperties().getProperty("tools");
    }

    public Long getTimeout() {
        return Long.valueOf(loadProperties().getProperty("timeout"));
    }

    public String getLocal() {
        return loadProperties().getProperty("local");
    }
}