package strategy;

import models.Locker;

import java.util.List;
import java.util.Optional;

public class DefaultSelectionStrategy implements LockerSelectionStrategy {

    @Override
    public Optional<Locker> getAvailableLocker(List<Locker> availableLockers) {
        if (availableLockers.isEmpty()) {
            return Optional.empty();
        }
         return availableLockers.stream().findFirst();
    }
}
