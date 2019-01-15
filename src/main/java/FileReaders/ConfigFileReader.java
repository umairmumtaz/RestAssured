package FileReaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigFileReader {

    private static Properties properties;

    private ConfigFileReader(){
        Path path = Paths.get("src/","Configuration.properties");
        File propertyFile = path.toFile();
        try {
            InputStream inputStream = new FileInputStream(propertyFile);
            properties = new Properties();
            properties.load(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static String getPropertyValue(String propertyName){
        if(properties==null){
            new ConfigFileReader();
        }
        return properties.getProperty(propertyName);
    }
}