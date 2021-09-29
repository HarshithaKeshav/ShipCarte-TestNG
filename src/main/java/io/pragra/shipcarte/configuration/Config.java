package io.pragra.shipcarte.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    private static Config instance;
    private String filename = "framework.properties";
    private Properties properties;
    private static Logger logger = LogManager.getLogger(Config.class);

    private Config() throws IOException {

        this.properties = new Properties();
        Path path = Paths.get("src/main/resources", filename);
        logger.debug("Reading file {} to load properties ", path.toString());

        try {
            InputStream stream = new FileInputStream(path.toFile());
            properties.load(stream);
        }
        catch (FileNotFoundException ex){
            logger.error("File {} not found in system, please correct the path" , path);
            throw ex;
        }
        catch (IOException ex){
            logger.error("File {} not be read, please check file", path);
        }


    }

    public synchronized static String getProperty(String key) throws IOException{
        if(instance == null){
            instance = new Config();
        }
        logger.debug("Reading property for the key{} ", key);
        String property = instance.properties.getProperty(key);
        if (property==null){
            logger.error("No property found for the key {} ", key);
            throw new RuntimeException("Property "+key+"not defined");

        }
        return property;
    }

}
