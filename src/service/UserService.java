package service;

import datastore.UserData;
import exceptions.DefaultException;
import models.User;

import java.util.UUID;

public class UserService {
    final private UserData userData;

    public UserService() {
        userData = new UserData();
    }


    public void addUser(final String phoneNumber) throws DefaultException {
        User user = new User(phoneNumber);
        userData.addUser(user);
    }

    public User getUser(final String phoneNumber) throws DefaultException {
        return userData.getUser(phoneNumber);
    }
}
