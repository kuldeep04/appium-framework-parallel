package org.AutomateMobile.driverManager.iOSDriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.AutomateMobile.driverManager.AppDriver;
import org.AutomateMobile.driverManager.AppiumServerFactory;
import org.AutomateMobile.driverManager.DriverFactory;
import org.AutomateMobile.dto.IOSDeviceInfo;
import java.io.IOException;
import java.time.Duration;

import static org.AutomateMobile.Utils.JsonUtils.getIosDeviceInfo;

public class IOSDriverFactory implements DriverFactory {

    private final IOSDeviceInfo.Device device;

    public IOSDriverFactory(IOSDeviceInfo.Device device) {
        this.device = device;

    }
    @Override
    public void createDriver() {
            try {
                XCUITestOptions options = getXCUITestOptions(device);
                AppiumDriverLocalService service = AppiumServerFactory.initiateAppiumServer();
                AppDriver.setService(service);
                AppDriver.setDriver(  new IOSDriver(AppDriver.getService().getUrl(), options));
            } catch (Exception e) {
                throw new RuntimeException("Failed to create new iOS driver " + e.getMessage());
            }
    }

    public static XCUITestOptions getXCUITestOptions(IOSDeviceInfo.Device config) throws IOException {
        IOSDeviceInfo iosDeviceInfo = new IOSDeviceInfo();
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(config.getPlatformName());
        options.setUdid(config.getDeviceName());
        options.setAutomationName(config.getAutomationName());
        options.setApp(iosDeviceInfo.getAppPath()); // .ipa
        options.setNoReset(true);
        options.setWdaLaunchTimeout(Duration.ofSeconds(60));
        options.setBundleId(getIosDeviceInfo().getBundleId());
        return options;
    }
}
