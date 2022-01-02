package com.pos.utility;

import com.pos.entity.UserTable;

public class LoggedUser {
     private static UserTable loggedUser = null;
    
    private LoggedUser(){
        
    }
    
    public static UserTable getLoggedUser(){
        return loggedUser;
    }
    
    public static void setLoggedUser(UserTable user){
        loggedUser = user;
    }

}
