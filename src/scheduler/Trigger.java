package scheduler;

import devices.Device;

public class Trigger {
    private Device triggeringDevice;
    private String attribute;
    private String operator;
    private int thresholdValue;
    private Device affectedDevice;

    public Trigger(Device triggeringDevice, String attribute, String operator, int thresholdValue, Device affectedDevice) {
        this.triggeringDevice = triggeringDevice;
        this.attribute = attribute;
        this.operator = operator;
        this.thresholdValue = thresholdValue;
        this.affectedDevice = affectedDevice;
    }

    public void checkCondition(int currentValue) {
        if (evaluateCondition(currentValue)) {
            System.out.println("Trigger activated: Affecting device " + affectedDevice.getId());
            affectedDevice.turnOff(); // For example, we could turn off the affected device
        }
    }

    private boolean evaluateCondition(int currentValue) {
        switch (operator) {
            case ">":
                return currentValue > thresholdValue;
            case "<":
                return currentValue < thresholdValue;
            case "==":
                return currentValue == thresholdValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
