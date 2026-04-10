package org.AutomateMobile.driverManager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Getter;
import org.AutomateMobile.Utils.LoggerUtils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import static org.AutomateMobile.Utils.JsonUtils.getAppiumConfig;

@Getter
public class AppiumServerFactory {

    public AppiumServerFactory() {
    }

    public static AppiumDriverLocalService initiateAppiumServer() throws IOException {
        int port = checkAvailablePorts(getAppiumConfig().getAppiumPort());

        if (AppDriver.getService() != null && AppDriver.getService().isRunning()) {
            return AppDriver.getService();
        }

        try {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withIPAddress(getAppiumConfig().getIpAddress())
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                    .withLogFile(new File("./target/logs/appium.log"));
            AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
            service.start();

            if (!service.isRunning()) {
                throw new RuntimeException("Appium server failed to start on port: " + port);
            }

            LoggerUtils.info("✅ Appium Service Started on port: " + port);
            return service;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Appium server instance " + e.getMessage());
        }
    }

    public static int checkAvailablePorts(int startPort) throws IOException {
        int port = startPort;
        while (port < 4799) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                serverSocket.close();
                return port;
            } catch (IOException e) {
                port++;
            }
        }
        throw new IOException("No available ports found starting from " + startPort);
    }


}
