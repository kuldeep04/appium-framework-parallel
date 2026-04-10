package org.AutomateMobile.driverManager.androidDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.AutomateMobile.driverManager.AppDriver;
import org.AutomateMobile.driverManager.AppiumServerFactory;
import org.AutomateMobile.driverManager.DriverFactory;
import org.AutomateMobile.dto.AndroidDeviceInfo;
import org.AutomateMobile.dto.AppiumConfig;

import java.io.IOException;
import java.time.Duration;

import static org.AutomateMobile.Utils.JsonUtils.getAndroidDeviceInfo;
import static org.AutomateMobile.Utils.JsonUtils.getAppiumConfig;

public class AndroidDriverFactory implements DriverFactory {

    private final AndroidDeviceInfo.Device device;

    public AndroidDriverFactory(AndroidDeviceInfo.Device device) {
        this.device = device;
    }

    @Override
    public void createDriver() {
        try {
            UiAutomator2Options options = getUiAutomator2Options(device);
            AppiumDriverLocalService service = AppiumServerFactory.initiateAppiumServer();
            AppDriver.setService(service);
            AppDriver.setDriver(new AndroidDriver(AppDriver.getService().getUrl(), options));
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Android driver " + e.getMessage());
        }
    }

    private static UiAutomator2Options getUiAutomator2Options(AndroidDeviceInfo.Device config) throws IOException {
        AndroidDeviceInfo androidDeviceInfo = new AndroidDeviceInfo();
        AppiumConfig appiumConfig = getAppiumConfig();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(androidDeviceInfo.getApp());
        options.setPlatformName(config.getPlatformName());
        options.setUdid(config.getUdid());
        options.setSystemPort(Integer.parseInt(config.getSystemPort()));
        options.setUiautomator2ServerLaunchTimeout(Duration.ofMillis(appiumConfig.getSetUiautomator2ServerLaunchTimeout()));
        options.setUiautomator2ServerInstallTimeout(Duration.ofMillis(appiumConfig.getUiautomator2ServerInstallTimeout()));
        options.setAdbExecTimeout(Duration.ofMillis(appiumConfig.getAdbExecTimeout()));
        options.setPlatformVersion(config.getPlatformVersion());
        options.setAutomationName(config.getAutomationName());
        options.setAppPackage(getAndroidDeviceInfo().getAppPackage());
        options.setAppActivity(getAndroidDeviceInfo().getAppActivity());
        return options;
    }
}
