package org.AutomateMobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppiumConfig {

    private String ipAddress;
    private Integer setUiautomator2ServerLaunchTimeout;
    private Integer uiautomator2ServerInstallTimeout;
    private Integer adbExecTimeout;

}
