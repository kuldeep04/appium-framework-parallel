package org.AutomateMobile.baseTest;

import org.AutomateMobile.constants.EnvConfig;
import org.AutomateMobile.deviceManager.AndroidDevicePool;
import org.AutomateMobile.deviceManager.IOSDevicePool;
import org.AutomateMobile.driverManager.DriverManager;
import org.AutomateMobile.executionManager.TestLifecycleManager;
import org.testng.annotations.*;

import java.io.IOException;

import static org.AutomateMobile.driverManager.AppDriver.getDriver;

public class BaseTest extends TestLifecycleManager {

    EnvConfig envConfig;

    public BaseTest() {
        this.envConfig = new EnvConfig();
    }

    @Override
    @BeforeMethod
    public void beforeMethod() throws IOException {
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
    }

    @Override
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        try {
            if (getDriver() != null) {
                getDriver().quit();
            }
        } finally {
            if (envConfig.getPlatform().equalsIgnoreCase("Android")) {
                AndroidDevicePool.releaseDevice(DriverManager.getAndroidDeviceHolder().get());
            } else if (envConfig.getPlatform().equalsIgnoreCase("iOS")) {
                IOSDevicePool.releaseDevice(DriverManager.getIOSDeviceHolder().get());
            }
        }
    }

    @BeforeTest
    @Override
    public void beforeTestSetup() throws IOException {

    }

    @AfterTest
    @Override
    public void afterTestTearDown() {

    }
}
