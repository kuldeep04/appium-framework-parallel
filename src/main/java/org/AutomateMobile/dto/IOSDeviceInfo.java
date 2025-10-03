package org.AutomateMobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IOSDeviceInfo {

    private String bundleId;
    private String xcodeOrgId;
    private String xcodeSigningId;
    private List<Device> devices;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Device {
        private String automationName;
        private String udid;
        private String platformName;
        private String deviceName;
        private String webkitDebugProxyPort;
        private String wdaLocalPort;
        private String appPath;
    }
}
