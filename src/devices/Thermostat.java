package devices;

public class Thermostat implements Device {
    private int id;
    private int temperature;

    public Thermostat(int id) {
        this.id = id;
        this.temperature = 70; // Default temperature
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is set to " + temperature + " degrees.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is off.");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Thermostat " + id + " temperature set to " + temp + " degrees.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees.";
    }

    @Override
    public int getId() {
        return id;
    }
}
