package org.AutomateMobile.driverManager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.AutomateMobile.Utils.JsonUtils.getAppiumConfig;

@Getter
public class AppiumServerFactory {

    private static AppiumServerFactory instance;
    private final Map<String, AppiumDriverLocalService> servers;
    private final int port;
    private final String udId;

    private AppiumServerFactory(int port, String udId){
        this.servers = new ConcurrentHashMap<>();
        this.port = port;
        this.udId= udId;
    }

    public static synchronized AppiumServerFactory getInstance(int port, String udId){
        if(instance == null){
           instance = new AppiumServerFactory(port, udId);
        }
        return instance;
    }

    public Map<String, AppiumDriverLocalService> getServer() {
        return servers;
    }


    public synchronized void initiateAppiumServer() throws IOException {
        try {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withIPAddress(getAppiumConfig().getIpAddress())
                    .usingPort(port)
                    .withArgument(GeneralServerFlag.RELAXED_SECURITY)
                    .withLogFile(new File("./appium.log"));
            AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
            service.start();
            if (service.isRunning()) {
                servers.put(udId, service);
                System.out.println("Appium Service Started at Port number " + port + " and for UDID" +udId);
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to create Appium server instance "+e.getMessage());
        }
    }

    public synchronized int checkAvailablePorts(int startPort) throws IOException {
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
