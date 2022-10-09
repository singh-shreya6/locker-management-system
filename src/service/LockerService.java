package service;

import datastore.LockersData;
import exceptions.DefaultException;
import models.*;
import models.Package;
import strategy.DefaultSelectionStrategy;

import java.util.UUID;

public class LockerService {

    private final LockersData lockersData;
    private UserService userService;

    public LockerService() {
        this.lockersData = new LockersData(new DefaultSelectionStrategy());
        this.userService = new UserService();
    }

    public void addLockers(int smallLockers, int mediumLockers, int largeLocker) throws DefaultException {

        for(int i = 1; i <= smallLockers; i++) {
            Locker locker = new Locker(generateId(i, LockerType.SMALL), LockerType.SMALL, true);
            lockersData.addLocker(locker);
        }
        for(int i = 1; i <= mediumLockers; i++) {
            Locker locker = new Locker(generateId(i, LockerType.MEDIUM), LockerType.MEDIUM, true);
            lockersData.addLocker(locker);
        }
        for(int i = 1; i <= largeLocker; i++) {
            Locker locker = new Locker(generateId(i, LockerType.LARGE), LockerType.LARGE, true);
            lockersData.addLocker(locker);
        }
    }

    public void requestLocker(final PackageType packageType, final String phoneNumber) throws DefaultException {
        final User user = userService.getUser(phoneNumber);
        final Package pkg = new Package(UUID.randomUUID().toString(), packageType, user);
        final Locker locker = lockersData.getAvailableLocker(packageType.getLockerType());
        locker.setAvailable(false);
        locker.setPkg(pkg);
        System.out.println("Successfully allocated locker " + locker.getId());
    }

    private String generateId(int i, LockerType lockerType) {
        return lockerType.toString() + "-" + i;
    }

    public void getLocker() throws DefaultException{
        lockersData.getLockers();
    }
}
