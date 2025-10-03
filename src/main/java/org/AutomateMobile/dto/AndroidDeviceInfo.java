package org.AutomateMobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AndroidDeviceInfo {

    private String appPackage;
    private String appActivity;
    private String app;
    private List<Device> devices;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Device {
        private String automationName;
        private String udid;
        private String platformVersion;
        private String platformName;
        private String systemPort;
        private String deviceName;
    }
}
