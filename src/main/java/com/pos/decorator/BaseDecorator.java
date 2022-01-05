package com.pos.decorator;

import com.pos.observer.NotificationCenter;

public class BaseDecorator extends NotificationCenter {
    NotificationCenter wrapee;
    
    @Override
    public void notify(String message) {
        wrapee.notify(message);
    }
}
