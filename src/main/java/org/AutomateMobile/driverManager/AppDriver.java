package org.AutomateMobile.driverManager;

import io.appium.java_client.AppiumDriver;

public class AppDriver {

    private static AppDriver instance = null;
    private final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    private AppDriver(){}

    public static synchronized AppDriver getInstance(){
        if(instance == null){
            instance = new AppDriver();
        }
        return instance;
    }

    public synchronized void setDriver(AppiumDriver driver){
        if(driver == null){
            throw new IllegalArgumentException("Driver can not be null");
        }
        this.driver.set(driver);
    }

    public synchronized AppiumDriver getDriver(){
        return driver.get();
    }
}
