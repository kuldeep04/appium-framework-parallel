package org.AutomateMobile.deviceManager;

import java.io.IOException;
import static org.AutomateMobile.Utils.JsonUtils.getAndroidDeviceInfo;

public class AndroidDeviceManager implements ConfigManager {

    public AndroidDeviceManager(){}

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getDeviceDetails(String udId) throws IOException {
        Object deviceInfo =   getAndroidDeviceInfo().getDevices().stream().filter(
                device -> device.getUdid().equalsIgnoreCase(udId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Device not found with udid: " + udId));
        return (T) deviceInfo;
    }
}
