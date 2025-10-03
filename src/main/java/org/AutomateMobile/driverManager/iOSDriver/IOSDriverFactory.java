package org.AutomateMobile.driverManager.iOSDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.AutomateMobile.driverManager.DriverFactory;
import org.AutomateMobile.deviceManager.IOSDeviceManager;
import org.AutomateMobile.driverManager.AppiumServerFactory;
import org.AutomateMobile.dto.IOSDeviceInfo;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static org.AutomateMobile.Utils.JsonUtils.getIosDeviceInfo;

public class IOSDriverFactory implements DriverFactory {

    public IOSDriverFactory(){
        IOSDeviceManager iOSdeviceManager = new IOSDeviceManager();
    }

    @Override
    public AppiumDriver createDriver() throws IOException {
        for (IOSDeviceInfo.Device device : getIosDeviceInfo().getDevices()) {
            try {
                XCUITestOptions options = new XCUITestOptions();
                options.setPlatformName(device.getPlatformName());
                options.setDeviceName(device.getDeviceName());
                options.setAutomationName(device.getAutomationName());
                options.setApp(device.getAppPath()); // .ipa or .app file
                options.setNoReset(true);
                options.setWdaLaunchTimeout(Duration.ofSeconds(60));
                options.setBundleId(getIosDeviceInfo().getBundleId());
                return new IOSDriver(new URL(""), options);
            } catch (Exception e) {
                throw new RuntimeException("Failed to create new iOS driver " + e.getMessage());
            }
        }
        return null;
    }
}
