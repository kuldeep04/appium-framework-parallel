package org.AutomateMobile.deviceManager;

import org.AutomateMobile.dto.IOSDeviceInfo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class IOSDevicePool {

    private static final Queue<IOSDeviceInfo.Device> availableDevices = new LinkedList<>();

    static {
        IOSDeviceManager iosDeviceManager = new IOSDeviceManager();
        try {
            availableDevices.addAll(iosDeviceManager.getDeviceDetails());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static IOSDeviceInfo.Device acquireDevice() {
        while (availableDevices.isEmpty()) {
            try {
                AndroidDevicePool.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return availableDevices.poll();
    }

    public synchronized static void releaseDevice(IOSDeviceInfo.Device device) {
        availableDevices.add(device);
        AndroidDevicePool.class.notify();
    }
}
