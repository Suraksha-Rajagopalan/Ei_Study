import devices.*;
import factory.DeviceFactory;
import scheduler.TaskScheduler;
import proxy.DeviceProxy;

public class Main {
    public static void main(String[] args) {
        // Factory to create devices
        DeviceFactory factory = new DeviceFactory();

        // Creating devices
        Device light = factory.createDevice("Light", 1);
        Device thermostat = factory.createDevice("Thermostat", 2);
        Device doorLock = factory.createDevice("DoorLock", 3);

        // Device proxy for access control
        DeviceProxy lightProxy = new DeviceProxy(light);
        DeviceProxy thermostatProxy = new DeviceProxy(thermostat);

        // Turn devices on using proxy
        lightProxy.turnOn();
        thermostatProxy.turnOn();

        // Scheduler example
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.scheduleDeviceOn(light, "06:00");

        // Setting an automated trigger
        scheduler.addTrigger(thermostat, "temperature", ">", 75, light);
    }
}
