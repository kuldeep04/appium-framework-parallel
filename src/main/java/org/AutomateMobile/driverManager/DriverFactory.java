package org.AutomateMobile.driverManager;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public interface DriverFactory {
    AppiumDriver createDriver() throws IOException;
}
