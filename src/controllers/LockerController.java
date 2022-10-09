package controllers;

import exceptions.DefaultException;
import models.PackageType;
import service.LockerService;

public class LockerController {
    final LockerService lockerService;

    public LockerController() {
        this.lockerService = new LockerService();
    }

    public void createLocker(final int smallLockers, final int mediumLockers, final int largeLockers) {
        try {
            lockerService.addLockers(smallLockers, mediumLockers, largeLockers);
        } catch (DefaultException e) {
            System.out.println(e);
        }
    }

    public void getLocker() {

        try {
            lockerService.getLocker();
        } catch (DefaultException e) {
            System.out.println(e);
        }
    }


    public void request(final String packageType, final String phoneNumber) {
        try {
            lockerService.requestLocker(PackageType.valueOf(packageType), phoneNumber);
        } catch (DefaultException e) {
            System.out.println(e);
        }
    }
}


