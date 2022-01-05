package com.pos.decorator;

public class ConsoleDecorator extends BaseDecorator {
    @Override
    public void notify(String message) {
        consoleOputput(message);
        super.notify(message); 
    }

    private void consoleOputput(String message) {
        System.out.println(message);
    }
}
