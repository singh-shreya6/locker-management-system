package controllers;

import exceptions.DefaultException;
import service.UserService;

public class UserController {
    final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public void addUser(final String phoneNumber) {
        try {
            userService.addUser(phoneNumber);
        } catch (DefaultException e) {
            System.out.println(e);
        }
    }
}
