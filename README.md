# Ei_Study


# Smart Home System

This is a **Java-based Smart Home System** simulation that allows users to control various smart devices (like lights, thermostats, and door locks) through a central hub. The system supports actions like turning devices on/off, scheduling tasks, and automating actions based on triggers. The implementation follows best practices such as Object-Oriented Programming (OOP), SOLID principles, and applies several design patterns, including **Factory Method**, **Observer**, and **Proxy**.

## Table of Contents
- [Project Structure](#project-structure)
- [Design Patterns Used](#design-patterns-used)
- [Features](#features)
- [How to Run](#how-to-run)
- [Example Usage](#example-usage)
- [Classes Overview](#classes-overview)
- [Future Enhancements](#future-enhancements)

---

## Project Structure
```
SmartHomeSystem/
    ├── src/
    │   ├── Main.java                # Entry point for the application
    │   ├── devices/                 # Contains device classes
    │   │   ├── Device.java          # Device interface (common to all devices)
    │   │   ├── Light.java           # Light device implementation
    │   │   ├── Thermostat.java       # Thermostat device implementation
    │   │   └── DoorLock.java        # Door Lock device implementation
    │   ├── factory/                 # Contains the Factory Method
    │   │   └── DeviceFactory.java   # Factory class for creating devices
    │   ├── observer/                # Observer pattern implementation
    │   │   ├── Subject.java         # Subject interface for observers
    │   │   └── Observer.java        # Observer interface
    │   ├── proxy/                   # Proxy pattern for access control
    │   │   ├── DeviceProxy.java     # Proxy for controlling device access
    │   │   └── AccessControl.java   # Placeholder for access control logic
    │   └── scheduler/               # Scheduler and automation logic
    │       ├── TaskScheduler.java   # Handles scheduling tasks
    │       └── Trigger.java         # Handles automated triggers
    └── README.md                    # This readme file
```

---

## Design Patterns Used

1. **Factory Method Pattern**:  
   - Used to create different types of devices (Lights, Thermostats, Door Locks). The factory ensures that device creation is encapsulated and can easily be extended by adding more devices.
   
2. **Proxy Pattern**:  
   - Used for access control. The `DeviceProxy` class ensures that access to a device (turning it on/off) goes through a proxy, which can check user permissions or perform other checks.
   
3. **Observer Pattern**:  
   - Can be extended to notify devices about system-wide changes, like automated triggers that respond to temperature changes, turning off lights when needed.

---

## Features

- **Add Devices**: Create different smart devices like lights, thermostats, and door locks.
- **Turn Devices On/Off**: Devices can be turned on/off either directly or through a proxy for controlled access.
- **Schedule Tasks**: Schedule devices to turn on/off at specific times.
- **Automate Tasks**: Automate device actions based on triggers (e.g., turn off lights when the thermostat reaches a certain temperature).

---

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd SmartHomeSystem
   ```

2. **Compile the Code**:
   ```bash
   javac src/**/*.java
   ```

3. **Run the Application**:
   ```bash
   java -cp src Main
   ```

---

## Example Usage

Here’s an example of what you can do with the Smart Home System:

```java
DeviceFactory factory = new DeviceFactory();

// Create devices
Device light = factory.createDevice("Light", 1);
Device thermostat = factory.createDevice("Thermostat", 2);

// Use proxies for access control
DeviceProxy lightProxy = new DeviceProxy(light);
DeviceProxy thermostatProxy = new DeviceProxy(thermostat);

// Turn devices on through the proxy
lightProxy.turnOn();
thermostatProxy.turnOn();

// Schedule tasks
TaskScheduler scheduler = new TaskScheduler();
scheduler.scheduleDeviceOn(light, "06:00");

// Add automation triggers
scheduler.addTrigger(thermostat, "temperature", ">", 75, light);
```

**Output**:
```
Proxy: Checking access before turning on device 1
Light 1 is turned on.
Proxy: Checking access before turning on device 2
Thermostat 2 is set to 70 degrees.
Scheduled 1 to turn on at 06:00.
Added trigger: If 2's temperature > 75, then affect 1
```

---

## Classes Overview

- **`Device` Interface**:  
  Defines the basic functionalities (turnOn, turnOff, getStatus) that all devices must implement.

- **`Light`, `Thermostat`, `DoorLock` Classes**:  
  These are concrete implementations of the `Device` interface. Each class defines the behavior specific to the type of device (e.g., a `Light` can be turned on/off, and a `Thermostat` has temperature control).

- **`DeviceFactory` Class**:  
  Uses the Factory Method pattern to instantiate devices. By passing the device type (like "Light", "Thermostat"), it returns an instance of the correct device class.

- **`DeviceProxy` Class**:  
  Implements the Proxy pattern to control access to devices, performing checks before calling the actual device methods.

- **`TaskScheduler` Class**:  
  Allows scheduling tasks for devices, such as turning them on/off at specific times, as well as adding automated triggers for certain conditions (e.g., temperature thresholds).

- **`Trigger` Class**:  
  Handles the logic for automating tasks based on triggers (e.g., when the thermostat temperature exceeds a threshold, another device is triggered to turn off).

---

## Future Enhancements

- **Dynamic Device Addition**:  
  Currently, devices are added manually in the code. Future improvements could include adding/removing devices dynamically at runtime.

- **Real-Time Trigger Evaluation**:  
  The system can be extended to continuously monitor devices in real time and automatically respond to triggers like changes in temperature.

- **User Authentication**:  
  Implement user authentication to control access to device management features.

---

## Conclusion

This project demonstrates a Smart Home System simulation using core OOP principles and design patterns like Factory, Proxy, and Observer. The code is designed to be modular, scalable, and maintainable. The system can easily be extended by adding more device types and automation rules.
