package proxy;

import devices.Device;

public class DeviceProxy {
    private Device device;
    private AccessControl accessControl;

    // Constructor to pass the device and set up access control
    public DeviceProxy(Device device) {
        this.device = device;
        this.accessControl = new AccessControl(true); // Default: Access granted (can be customized)
    }

    // Constructor to specify access control dynamically
    public DeviceProxy(Device device, AccessControl accessControl) {
        this.device = device;
        this.accessControl = accessControl;
    }

    // Method to turn on the device with access control check
    public void turnOn() {
        System.out.println("Proxy: Checking access before turning on device " + device.getId());
        if (accessControl.isAccessGranted()) {
            device.turnOn();
        } else {
            System.out.println("Access denied for turning on device " + device.getId());
        }
    }

    // Method to turn off the device with access control check
    public void turnOff() {
        System.out.println("Proxy: Checking access before turning off device " + device.getId());
        if (accessControl.isAccessGranted()) {
            device.turnOff();
        } else {
            System.out.println("Access denied for turning off device " + device.getId());
        }
    }
}
