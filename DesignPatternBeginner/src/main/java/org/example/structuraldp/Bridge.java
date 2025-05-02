package org.example.structuraldp;

import org.example.structuraldp.bridge.*;

public class Bridge {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new RemoteControl(tv);

        remote.togglePower();  // TV is enabled
        remote.volumeUp();      // TV volume set to 40

        Device radio = new Radio();
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

        advancedRemote.togglePower();  // Radio is enabled
        advancedRemote.volumeDown();    // Radio volume set to 40
        advancedRemote.mute();          // Device muted
    }
}
