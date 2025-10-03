package org.AutomateMobile.driverManager;

import io.appium.java_client.AppiumDriver;
import org.AutomateMobile.driverManager.androidDriver.AndroidDriverFactory;
import org.AutomateMobile.driverManager.iOSDriver.IOSDriverFactory;

import java.io.IOException;

public class DriverManager {

    public void initializeDriver() throws IOException {
        DriverFactory factory;
        String platform = System.getProperty("platform");
        if(platform.equalsIgnoreCase("Android")){
           factory =  new AndroidDriverFactory();
        } else if (platform.equalsIgnoreCase("ios")) {
            factory = new IOSDriverFactory();
        }else {
            throw new IllegalArgumentException("Invalid Platform"+ platform);
        }
        AppiumDriver driver = factory.createDriver();
        AppDriver.getInstance().setDriver(driver);
    }
}
