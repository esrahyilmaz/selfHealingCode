package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper extends BaseClass {

    public static String getProperty(String key) {
        return getProperty("/src/test/resources/config/config.properties", key);
    }

    public static String getProperty(String filePath, String key) {
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(System.getProperty("user.dir") + filePath));
        } catch (IOException e) {
            log.info("Unable to load Data");
        }
        return property.getProperty(key);
    }
}
