package com.pos.utility;

import com.pos.observer.NotificationCenter;

public class Notification {
    public static NotificationCenter events = new NotificationCenter();
    public static NotificationCenter decoratorEvents = new NotificationCenter();
    public static int notificationCount = 0;
}
