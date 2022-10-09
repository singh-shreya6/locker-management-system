package strategy;

import models.Locker;

import java.util.List;
import java.util.Optional;

public interface LockerSelectionStrategy {

    public Optional<Locker> getAvailableLocker(List<Locker> availableLockers);
}
