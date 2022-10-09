package models;

public enum PackageType {
    FOOD(LockerType.SMALL),
    ELECTRONICS(LockerType.MEDIUM),
    FURNITURE(LockerType.LARGE);

    private final LockerType lockerType;

    PackageType(LockerType lockerType) {
        this.lockerType = lockerType;
    }

    public LockerType getLockerType() {
        return lockerType;
    }
}
