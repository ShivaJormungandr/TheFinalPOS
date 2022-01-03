package com.pos.observer;

public class BrowserNotificationListener implements EventListener {
    private Integer id;
    
    public BrowserNotificationListener(Integer id){
        this.id = id;
    }
    
    @Override
    public void update(String message) {
        System.out.println(message);
    }

}
