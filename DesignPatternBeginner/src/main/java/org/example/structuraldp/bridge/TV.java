package org.example.structuraldp.bridge;

public class TV implements Device {
    private boolean on = false;
    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("TV is enabled");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV is disabled");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("TV volume set to " + volume);
    }
}




