package org.AutomateMobile.constants;

import lombok.Getter;

@Getter
public enum FilePaths {

    androidDeviceInfo("/androidDeviceInfo.json"),
    iOSDeviceDeviceInfo("/iOSDeviceInfo.json"),
    appiumConfig("/appiumConfig.json");

    private final String path;

    FilePaths(String path) {
        this.path = path;
    }

}
