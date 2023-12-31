package org.example.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public enum ConfigFile {

    INSTANCE;
    public static String BaseURL;
    public static String Browser;

    public void init(){
        Properties prop = new Properties();
        URL configFile = configFile();
        try{
        prop.load(configFile.openStream());
        }catch (IOException e){
            System.out.println(e);
        }
        BaseURL = prop.getProperty("devEnvironment");
        Browser = prop.getProperty("browser");
    }

    private URL configFile(){
        URL configFile = this.getClass().getClassLoader().getResource("config.properties");
        return configFile;
    }
}
