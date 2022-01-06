package com.pos.utility;

import com.pos.entity.UserTable;
import java.util.ArrayList;
import java.util.List;

public class LoggedUsers {
    private List<UserTable> loggedUsers = null;
    
    private static LoggedUsers instance = null;
    
    public static LoggedUsers getInstance(){
        if (instance == null) {
            instance = new LoggedUsers();
        }
        
        return instance;
    }
    
    private LoggedUsers(){
        
    }
    
    public List<UserTable> getLoggedUsers(){
        return loggedUsers;
    }
    
    public void addLoggedUser(UserTable user) {
        if (loggedUsers == null) {
            loggedUsers = new ArrayList<UserTable>();
        }
        
        loggedUsers.add(user);
    }
    
    public UserTable getLoggedUserById(int userId) {
        for (UserTable user : loggedUsers) {
            if (user.getId() == userId){
                return user;
            }
        }
        
        return null;
    }

    public void logoutUser(UserTable user) {
        loggedUsers.remove(user);
    }
    
    public boolean isUserLogged(UserTable user) {
        return loggedUsers.contains(user);
    }
}
