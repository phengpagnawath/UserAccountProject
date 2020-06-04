package com.dgb.view;

import com.dgb.Utils.Constants;
import com.dgb.Utils.Utils;
import com.dgb.exception.MissMatchPasswordException;
import com.dgb.model.User;

public class UserView {

    public User registerUserView(){
        String userName = Utils.inputString(Constants.INPUT("User Name -> "));
        try {
            String password = Utils.inputString("Password -> ");
            String confirmPassword = Utils.inputString("Confirm Password -> ");
            if(!password.equals(confirmPassword))
                throw new MissMatchPasswordException(Constants.CONFIRM_PASSWORD_INCORRECT);
            return new User(userName,password);
        }catch (MissMatchPasswordException exception){
            exception.printStackTrace();
        }
        return null;
    }
    public User loginUser(){
        String userName=Utils.inputString(Constants.INPUT("User Name -> "));
        String password = Utils.inputString("Password -> ");
        return new User(userName,password);
    }
    public String searchUser(){
        return Utils.inputString(Constants.INPUT("user name -> "));
    }
}
