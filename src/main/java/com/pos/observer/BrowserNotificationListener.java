package com.pos.observer;

public class BrowserNotificationListener implements EventListener {
    public String message;
    
    public BrowserNotificationListener(){
    }
    
    @Override
    public void update(String message) {
        System.out.println(message);
        
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
}
