package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            ExceptionHandler.logException("Failed to load config.properties", e);
            throw new RuntimeException("Failed to load config.properties", e);
        } catch (Exception e) {
            ExceptionHandler.logException("Unexpected error loading config.properties", e);
            throw new RuntimeException("Unexpected error loading config.properties", e);
        }
    }

    public static String getEnv() {
        try {
            String envFromSys = System.getProperty("env");
            String env = (envFromSys != null && !envFromSys.isEmpty())
                ? envFromSys.toLowerCase()
                : properties.getProperty("env");

            if (env == null || env.isEmpty()) {
                throw new RuntimeException("Environment 'env' is not defined in system property or config file");
            }

            return env.toLowerCase();
        } catch (Exception e) {
            ExceptionHandler.logException("Error retrieving environment", e);
            throw e;
        }
    }

    public static String getUrl() {
        return getPropertyWithHandling(getEnv() + ".url", "URL");
    }

    public static String getUsername() {
        return getPropertyWithHandling(getEnv() + ".username", "Username");
    }

    public static String getPassword() {
        return getPropertyWithHandling(getEnv() + ".password", "Password");
    }

    private static String getPropertyWithHandling(String key, String label) {
        try {
            String value = properties.getProperty(key);
            if (value == null || value.isEmpty()) {
                throw new RuntimeException(label + " not configured for key: " + key);
            }
            return value;
        } catch (Exception e) {
            ExceptionHandler.logException("Failed to retrieve property: " + key, e);
            throw e;
        }
    }
}
