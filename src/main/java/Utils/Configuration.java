package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  Класс для про слушивания проперти файла. с возможностью подгрузки из вне
 *  */
public class Configuration {
    private static final String CONFIGURATION_FILE = "/test.properties";
    private static final Properties properties;
    private static final String LOCAL_LOGINS_FILE = "/local/logins.properties";
    private static final String LOGINS_FILE = "/logins.properties";

    static {
        properties = new Properties();
        try (InputStream inputStream = Configuration.class.getResourceAsStream(CONFIGURATION_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file" + CONFIGURATION_FILE, e);
        }

        InputStream inputStream2 = Configuration.class.getResourceAsStream(LOGINS_FILE);
        try {
            properties.load(inputStream2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (properties.getProperty("adminLogin").isEmpty()) {
            InputStream inputStream3 = Configuration.class.getResourceAsStream(LOCAL_LOGINS_FILE);
            try {
                properties.load(inputStream3);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /** Эта строка смотрит на входящие данные из вне. Допустим можно указать данные в Jenkins, если таких данных нет то брать из проперти файла */
    public static String getConfigurationValue(String key) {

        return ((System.getProperty(key) == null) ? properties.getProperty(key) : System.getProperty(key));
    }

    public Configuration(){

    }
}
