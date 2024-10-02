package devices;

public class Light implements Device {
    private int id;
    private boolean isOn;

    public Light(int id) {
        this.id = id;
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light " + id + " is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light " + id + " is turned off.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "on" : "off");
    }

    @Override
    public int getId() {
        return id;
    }
}
