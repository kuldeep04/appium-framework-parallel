package org.AutomateMobile.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppDriver {

    private AppDriver(){}

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver d) {
        driver.set(d);
    }

    public static void setService(AppiumDriverLocalService s) {
        service.set(s);
    }

    public static AppiumDriverLocalService getService() {
        return service.get();
    }

}
