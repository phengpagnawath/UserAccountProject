package com.dgb.controller;

import com.dgb.Utils.Constants;
import com.dgb.Utils.Utils;
import com.dgb.exception.UserNotFoundException;
import com.dgb.exception.UserPasswordException;
import com.dgb.model.User;
import com.dgb.model.UserCrud;
import com.dgb.view.UserView;

import java.util.List;

public class UserController {
    UserView userView;
    UserCrud userCrud;

    public UserController() {
        userView = new UserView();
        userCrud = new UserCrud();
    }

    public void registerUser() {
        User user = userView.registerUserView();
        if (user == null) {
            System.out.println(Constants.TRY_AGAIN);
            Utils.pressKeyEnter(Constants.PRESS_KEY_ENTER);
            user = userView.registerUserView();
        }
        userCrud.createUser(user);
        System.out.println(Constants.MSG_SUCCESS);
    }

    public boolean loginUser() {
        User user = userView.loginUser();
        List<User> data = userCrud.retrieveAllUser();
        if (user == null) {
            System.out.println(Constants.TRY_AGAIN);
            Utils.pressKeyEnter(Constants.PRESS_KEY_ENTER);
            user = userView.loginUser();
        }
        try {
            for (User allUser : data) {
                System.out.println(Constants.LINE);
                if (allUser.getName().equals(user.getName()) && allUser.getPassword().equals(user.getPassword())) {
                    System.out.println(Constants.LOG_IN_SUCCESS);
                    System.out.println(Constants.WELCOME);
                    return true;
                }
            }
            throw new UserPasswordException(Constants.INCORRECT_USER_PASSWORD);
        } catch (UserPasswordException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public boolean searchUser() {
        String username = userView.searchUser();
        List<User> data = userCrud.retrieveAllUser();
        try {
            for (User user : data) {
                System.out.println(Constants.LINE);
                if (user.getName().equals(username)) {
                    System.out.println(Constants.USER_FOUND);
                    System.out.println("Your result"+user.getName()+"\t\t"+user.getPassword());
                    return true;
                }
            }
            throw new UserNotFoundException(Constants.MSG_NOT_FOUND);
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
