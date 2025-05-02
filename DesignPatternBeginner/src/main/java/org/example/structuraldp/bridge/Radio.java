package org.example.structuraldp.bridge;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 50;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio is enabled");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio is disabled");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        volume = percent;
        System.out.println("Radio volume set to " + volume);
    }
}
