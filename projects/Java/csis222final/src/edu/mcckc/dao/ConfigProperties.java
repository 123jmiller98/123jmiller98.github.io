package edu.mcckc.dao;

import org.apache.log4j.*;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class ConfigProperties
{
    private static Logger logger = Logger.getLogger(ConfigProperties.class);

    private Properties properties;
    private String propertyFileName;
    private File configFile;
    InputStream inputStream;
    private Set<String> propertyKeys;
    private Enumeration propertyKeysEnum;

    public ConfigProperties()
    {
        this("config.properties");
    }

    public ConfigProperties(String propertyFileName)
    {
        logger.debug("---------------------------------------");
        logger.debug("       edu.mcckc.dao.ConfigProperties    CONSTRUCTOR");
        logger.debug("       PropertyFileName: " + propertyFileName);

        properties = new Properties();
        this.propertyFileName = propertyFileName;

        fileInputStreamFinderTechnique01();
        fileInputStreamFinderTechnique02();

        try
        {
            properties.load(inputStream);
            propertyKeys = properties.stringPropertyNames();
            propertyKeysEnum = properties.propertyNames();
        }
        catch(Exception ex)
        {
            logger.error(ex);
            logger.error("All CONFIG FILE finder techniques failed");
            logger.error("CONFIG FILE does not exist (or cannot be found given the supplied path)");
        }
    }

    private void fileInputStreamFinderTechnique01()
    {
        // this attempts to find the config file at the root of the project
        logger.debug("CONFIG FINDER TECHNIQUE #1");
        try
        {
            configFile = new File(propertyFileName);

            logger.debug(configFile.getAbsolutePath());

            inputStream = new FileInputStream(configFile);

            logger.debug("INPUT STREAM PROCESS OKAY ## 1");
        }
        catch (IOException ioex)
        {
            logger.error(ioex.toString());
            inputStream = null;
        }
    }

    private void fileInputStreamFinderTechnique02()
    {
        // this attempts to find the config file at the "SRC" root subdirectory
        try
        {
            if (inputStream == null)
            {
                logger.debug("CONFIG FINDER TECHNIQUE #2");
                logger.debug(propertyFileName);

                inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);

                logger.debug("INPUT STREAM PROCESS  OKAY ## 2");
                logger.debug("ISTR: " + inputStream.available());
                logger.debug("ISTR: " + inputStream.toString());
            }
        }
        catch (Exception ex)
        {
            logger.error(ex.toString());
            inputStream = null;
        }
    }

    public void displayProperties()
    {
        logger.debug("PROPERTIES / VALUES (AS PROPERTY KEYS):");
        for (String key : propertyKeys)
        {
            logger.debug(String.format("KEY: %s  :  PROPERTY: %s", key, properties.getProperty(key)));
        }

        logger.debug("\nPROPERTIES / VALUES (AS ENUMERATION):");
        while( propertyKeysEnum.hasMoreElements() )
        {
            String key  = (String)propertyKeysEnum.nextElement();
            logger.debug(String.format("KEY: %s  :  PROPERTY: %s", key, properties.getProperty(key)));
        }
    }

    public Set<String> getKeys()
    {
        return propertyKeys;
        //return properties.stringPropertyNames();
    }

    public String getProperty(String key)
    {
        return properties.getProperty(key);
    }

}
