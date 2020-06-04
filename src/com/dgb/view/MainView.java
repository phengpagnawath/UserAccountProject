package com.dgb.view;

import com.dgb.Utils.Constants;
import com.dgb.Utils.Utils;
import com.dgb.controller.UserController;

public class MainView {
    UserController userController;
    public MainView() {
        userController=new UserController();
        displayMenuView();
    }

    public void displayMenuView(){
        boolean ckh=false;
        System.out.println(Constants.MENU_OPTION);
        int choice = Utils.inputInteger(Constants.CHOOSE_OPTION);
        switch (choice){
            case 1:{
                userController.registerUser();
                break;
            }
            case 2:{
                ckh=userController.loginUser();
                if (!ckh)
                    System.out.print(Constants.TRY_AGAIN);
                break;
            }
            case 3:{
                ckh=userController.searchUser();
                if (!ckh)
                    System.out.print(Constants.TRY_AGAIN);
                break;
            }
            case 4:
                Utils.pressKeyEnter(Constants.GOODBYE);
                System.exit(0);
                break;
            default:{
                System.out.println(Constants.CHOSE_WRONG_OPTION);
            }
        }
        Utils.pressKeyEnter(Constants.PRESS_KEY_ENTER);
        displayMenuView();
    }
}
