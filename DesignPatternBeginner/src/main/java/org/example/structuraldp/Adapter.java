package org.example.structuraldp;
/*The Adapter Design Pattern is a structural design pattern that allows two incompatible
interfaces to work together. It acts as a bridge between two objects by converting the
interface of one class into an interface expected by the clients.

Explanation with Java Code Example
Real-world analogy:
A mobile charger acts as an adapter between a wall socket (providing 120V or 240V)
and a mobile phone battery (which needs 3V). The charger converts the voltage to the
required level, allowing incompatible interfaces (socket and phone) to work together.

Components in the example:
Volt: A simple class representing voltage.

Socket: Produces a fixed voltage (e.g., 120 volts).

SocketAdapter: Interface defining methods to get different voltages.

SocketClassAdapterImpl: Adapter using inheritance (class adapter).

SocketObjectAdapterImpl: Adapter using composition (object adapter).
*/

import org.example.structuraldp.adapter.SocketAdapter;
import org.example.structuraldp.adapter.SocketClassAdapterImpl;
import org.example.structuraldp.adapter.SocketObjectAdapterImpl;
import org.example.structuraldp.adapter.Volt;

public class Adapter {
    public static void main(String[] args) {
        testClassAdapter();
        testObjectAdapter();
    }

    private static void testClassAdapter() {
        SocketAdapter sockAdapter = new SocketClassAdapterImpl();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Class Adapter = " + v3.getVolts());
        System.out.println("v12 volts using Class Adapter = " + v12.getVolts());
        System.out.println("v120 volts using Class Adapter = " + v120.getVolts());
    }

    private static void testObjectAdapter() {
        SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v120 = getVolt(sockAdapter, 120);
        System.out.println("v3 volts using Object Adapter = " + v3.getVolts());
        System.out.println("v12 volts using Object Adapter = " + v12.getVolts());
        System.out.println("v120 volts using Object Adapter = " + v120.getVolts());
    }

    private static Volt getVolt(SocketAdapter sockAdapter, int volts) {
        switch (volts) {
            case 3:
                return sockAdapter.get3Volt();
            case 12:
                return sockAdapter.get12Volt();
            case 120:
                return sockAdapter.get120Volt();
            default:
                return sockAdapter.get120Volt();
        }
    }
}
