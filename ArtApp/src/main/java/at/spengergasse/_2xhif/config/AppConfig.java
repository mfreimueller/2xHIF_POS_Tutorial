package at.spengergasse._2xhif.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class AppConfig {

    public static AppConfig getInstance(String configFileName) throws IOException {
        URL configURL = Thread.currentThread().getContextClassLoader().getResource(configFileName);

        if (configURL == null) {
            throw new FileNotFoundException(configFileName);
        }

        try (FileReader fileReader = new FileReader(configURL.getPath())) {
            Properties properties = new Properties();
            properties.load(fileReader);

            return new AppConfig(properties);
        }

        // fileReader.close();
    }

    private final Properties properties;

    private AppConfig(Properties properties) {
        this.properties = properties;
    }

    public String getSupportedTourType() {
        return properties.getProperty("supportedTourType", "RandomTour");
    }

    public boolean isPublic() {
        String isPublic = properties.getProperty("isPublic");
        return Boolean.parseBoolean(isPublic);
    }

    public int getMaxPOIs() {
        String maxPOIs = properties.getProperty("maxPOIs");

        try {
            return Integer.parseInt(maxPOIs);
        } catch (NumberFormatException e) {
            return 0; // 0 == unlimited pois
        }
    }

}
