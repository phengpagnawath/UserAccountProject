package com.dgb.model;

import java.util.List;

public class UserCrud {
    DataCenter<User> dataCenter;

    public UserCrud() {
        dataCenter= new DataCenter<>();
        dataCenter.getData().add(new User("Dara","123"));
    }
    public void createUser(User user){
        dataCenter.getData().add(user);
    }
    public List<User> retrieveAllUser(){
        return dataCenter.getData();
    }
}
