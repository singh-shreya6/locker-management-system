package datastore;

import exceptions.DefaultException;
import models.Package;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private final Map<String, User> phoneNumberToUserMap;

    public UserData() {
        phoneNumberToUserMap = new HashMap<>();
    }

    private boolean userAlreadyPresent(String phoneNumber) {
        return phoneNumberToUserMap.containsKey(phoneNumber);
    }

    public void addUser(User user) throws DefaultException {
        if (userAlreadyPresent(user.getPhoneNumber())) {
            throw new DefaultException("User already present");
        }
        phoneNumberToUserMap.put(user.getPhoneNumber(), user);
    }

    public User getUser(final String phoneNumber) throws DefaultException {
        if (!userAlreadyPresent(phoneNumber)) {
            addUser(new User(phoneNumber));
        }
        return phoneNumberToUserMap.get(phoneNumber);
    }
}
