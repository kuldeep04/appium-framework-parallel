package org.AutomateMobile.driverManager;

import org.AutomateMobile.driverManager.androidDriver.AndroidDriverFactory;
import org.AutomateMobile.driverManager.iOSDriver.IOSDriverFactory;

import java.io.IOException;

public class DriverManager {

    public void initializeDriver(int index) throws IOException {
        DriverFactory factory;
        String platform = System.getProperty("platform");
        if(platform.equalsIgnoreCase("Android")){
           factory =  new AndroidDriverFactory(index);
        } else if (platform.equalsIgnoreCase("ios")) {
            factory = new IOSDriverFactory();
        }else {
            throw new IllegalArgumentException("Invalid Platform"+ platform);
        }
        factory.createDriver();
    }
}
