package org.AutomateMobile.deviceManager;

import org.AutomateMobile.dto.AndroidDeviceInfo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class AndroidDevicePool {

    private static final Queue<AndroidDeviceInfo.Device> availableDevices = new LinkedList<>();

    static {
        AndroidDeviceManager androidDeviceManager = new AndroidDeviceManager();
        try {
            availableDevices.addAll(androidDeviceManager.getDeviceDetails());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static AndroidDeviceInfo.Device acquireDevice() {
        while (availableDevices.isEmpty()) {
            try {
                AndroidDevicePool.class.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return availableDevices.poll();
    }

    public synchronized static void releaseDevice(AndroidDeviceInfo.Device device) {
        availableDevices.add(device);
        AndroidDevicePool.class.notify();
    }
}
