package scheduler;

import devices.Device;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    private Map<Device, String> schedules = new HashMap<>();

    public void scheduleDeviceOn(Device device, String time) {
        schedules.put(device, time);
        System.out.println("Scheduled " + device.getId() + " to turn on at " + time);
    }

    public void addTrigger(Device triggeringDevice, String attribute, String operator, int value, Device affectedDevice) {
        // Simulate a trigger-based action
        System.out.println("Added trigger: If " + triggeringDevice.getId() + "'s " + attribute + " " + operator + " " + value + ", then affect " + affectedDevice.getId());
    }
}
