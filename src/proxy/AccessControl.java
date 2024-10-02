package proxy;

public class AccessControl {
    private boolean accessGranted;

    public AccessControl(boolean accessGranted) {
        this.accessGranted = accessGranted;
    }

    public boolean isAccessGranted() {
        return accessGranted;
    }

    public void grantAccess() {
        this.accessGranted = true;
    }

    public void revokeAccess() {
        this.accessGranted = false;
    }
}
