package com.pos.utility;

import com.pos.entity.UserTable;
import java.util.ArrayList;
import java.util.List;

public class LoggedUsers {
    private static List<UserTable> loggedUsers = null;
    
    private LoggedUsers(){
        
    }
    
    public static List<UserTable> getLoggedUsers(){
        return loggedUsers;
    }
    
    public static void addLoggedUser(UserTable user) {
        if (loggedUsers == null) {
            loggedUsers = new ArrayList<UserTable>();
        }
        
        loggedUsers.add(user);
    }

    public static void logoutUser(UserTable user) {
        loggedUsers.remove(user);
    }
    
    public static boolean isUserLogged(UserTable user) {
        return loggedUsers.contains(user);
    }
}
