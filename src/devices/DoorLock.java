package devices;

public class DoorLock implements Device {
    private int id;
    private boolean isLocked;

    public DoorLock(int id) {
        this.id = id;
        this.isLocked = true;
    }

    @Override
    public void turnOn() {
        isLocked = true;
        System.out.println("Door " + id + " is locked.");
    }

    @Override
    public void turnOff() {
        isLocked = false;
        System.out.println("Door " + id + " is unlocked.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + (isLocked ? "locked" : "unlocked");
    }

    @Override
    public int getId() {
        return id;
    }
}
