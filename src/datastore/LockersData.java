package datastore;

import exceptions.DefaultException;
import models.Locker;
import models.LockerType;
import models.Package;
import strategy.DefaultSelectionStrategy;
import strategy.LockerSelectionStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class LockersData {

    private final Map<LockerType, List<Locker>> lockerMap;
    private final LockerSelectionStrategy selectionStrategy;

    public LockersData(LockerSelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
        this.lockerMap = new HashMap<>();
    }

    public void addLocker(Locker locker) {
        if (lockerMap.containsKey(locker.getLockerType())) {
            lockerMap.get(locker.getLockerType()).add(locker);
        } else {
            lockerMap.put(locker.getLockerType(), new ArrayList<>(Arrays.asList(locker)));
        }
    }

    public void getLockers() {
        for(Map.Entry<LockerType, List<Locker>> entry : lockerMap.entrySet()) {
            for(Locker locker: entry.getValue()) {
                System.out.println(locker.getId());
            }
        }
    }

    public Locker getAvailableLocker(LockerType lockerType) throws DefaultException {
        if (lockerMap.isEmpty()) {
            throw new DefaultException("No locker exists!!");
        }

        List<Locker> availableLockers = lockerMap.get(lockerType).stream().filter(locker -> locker.isAvailable()).collect(Collectors.toList());

        Optional<Locker> selectedLocker = selectionStrategy.getAvailableLocker(availableLockers);

        if (!selectedLocker.isPresent()) {
            throw new DefaultException(lockerType.toString() + " locker capacity full!!");
        }
        return selectedLocker.get();
    }
}
