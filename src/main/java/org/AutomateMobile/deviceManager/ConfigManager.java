package org.AutomateMobile.deviceManager;

import java.io.IOException;

public interface ConfigManager {

    <T> T getDeviceDetails(String string) throws IOException;
}
