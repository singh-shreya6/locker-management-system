package models;

public class Locker {

    String id;
    LockerType lockerType;
    boolean available;
    Package pkg;

    public Package getPkg() {
        return pkg;
    }

    public void setPkg(Package pkg) {
        this.pkg = pkg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LockerType getLockerType() {
        return lockerType;
    }

    public void setLockerType(LockerType lockerType) {
        this.lockerType = lockerType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Locker(String id, LockerType lockerType, boolean available) {
        this.id = id;
        this.lockerType = lockerType;
        this.available = available;
        this.pkg = null;
    }
}
