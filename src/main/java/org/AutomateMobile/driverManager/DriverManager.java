package org.AutomateMobile.driverManager;

import lombok.Getter;
import org.AutomateMobile.constants.EnvConfig;
import org.AutomateMobile.deviceManager.AndroidDevicePool;
import org.AutomateMobile.deviceManager.IOSDevicePool;
import org.AutomateMobile.driverManager.androidDriver.AndroidDriverFactory;
import org.AutomateMobile.driverManager.iOSDriver.IOSDriverFactory;
import org.AutomateMobile.dto.AndroidDeviceInfo;
import org.AutomateMobile.dto.IOSDeviceInfo;

import java.io.IOException;

public class DriverManager {

    @Getter
    private static final ThreadLocal<AndroidDeviceInfo.Device> androidDeviceHolder = new ThreadLocal<>();
    @Getter
    private static final ThreadLocal<IOSDeviceInfo.Device> iOSDeviceHolder = new ThreadLocal<>();

    public void initializeDriver() throws IOException {
        DriverFactory factory;
        EnvConfig envConfig = new EnvConfig();
        if (envConfig.getPlatform().equalsIgnoreCase("Android")) {
            AndroidDeviceInfo.Device device = AndroidDevicePool.acquireDevice();
            androidDeviceHolder.set(device);
            factory = new AndroidDriverFactory(device);
        } else if (envConfig.getPlatform().equalsIgnoreCase("iOS")) {
            IOSDeviceInfo.Device device = IOSDevicePool.acquireDevice();
            iOSDeviceHolder.set(device);
            factory = new IOSDriverFactory(device);
        } else {
            throw new IllegalArgumentException("Invalid Platform" + envConfig.getPlatform());
        }
        factory.createDriver();
    }
}
