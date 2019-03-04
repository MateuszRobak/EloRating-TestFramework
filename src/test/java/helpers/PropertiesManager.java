package helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
    public static String PropertyReader(String path, String key) throws Exception{
        Properties property = new Properties();
        InputStream input = new FileInputStream(path);
        property.load(input);
        String propertyValue = property.getProperty(key);
        return propertyValue;
    }
}
