package com.pos.observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter {
    private List<EventListener> observers = new ArrayList<>();

    public void attach(EventListener observer) {
        observers.add(observer);
    }

    public void detach(EventListener observer) {
        observers.remove(observer);
    }

    public void notify(String message) {
        for (EventListener o : observers) {
            o.update(message);
        }
    }
}
