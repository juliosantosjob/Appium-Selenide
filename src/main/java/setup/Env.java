package setup;

import java.io.FileInputStream;
import java.util.Properties;

public class Env {
    private static final String PATH_PROP = "/src/main/java/resources/env.properties";
    private static final String PATH_PROJECT = System.getProperty("user.dir") + PATH_PROP;
    private static final Properties PROP = new Properties();

    public static Env env() {
        return new Env();
    }

    public static Properties loadProperties() {
        try {
            PROP.load(new FileInputStream(PATH_PROJECT));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Env.PROP;
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