package org.example.structuraldp.bridge;

public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);
    // Other device-specific methods...
}
