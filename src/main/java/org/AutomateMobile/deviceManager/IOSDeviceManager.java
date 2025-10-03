package org.AutomateMobile.deviceManager;

import java.io.IOException;

import static org.AutomateMobile.Utils.JsonUtils.getIosDeviceInfo;

public class IOSDeviceManager implements ConfigManager {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getDeviceDetails(String deviceId) throws IOException {
           Object deviceInfo = getIosDeviceInfo().getDevices().stream().filter(
                    device -> device.getDeviceName().equalsIgnoreCase(deviceId)
            ).findFirst().orElseThrow(() -> new IllegalArgumentException("Device not found with deviceId:  "+ deviceId));
       return (T) deviceInfo;
    }
}
