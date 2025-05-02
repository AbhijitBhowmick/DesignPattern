package org.example.lld.elevator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystemDemo {

    public static void main(String args[]) {
        ElevatorController system = new ElevatorController(2, 20, 3);
        system.start();

        // Simulate concurrent requests
        ExecutorService requests = Executors.newCachedThreadPool();
        requests.execute(() -> system.requestElevator(3, 15));
        requests.execute(() -> system.requestElevator(7, 2));
        requests.execute(() -> system.requestElevator(0, 19));
        requests.shutdown();
    }
}
