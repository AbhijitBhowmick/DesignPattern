package org.example.lld.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Elevator {
    private final int id;
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int currentFloor = 0;
    private int passengers = 0;
    private final PriorityQueue<Integer> destinations = new PriorityQueue<>();
    private int direction = 0; // -1: down, 0: idle, 1: up
    private final int numFloors;

    public Elevator(int id, int capacity, int numFloors) {
        this.id = id;
        this.capacity = capacity;
        this.numFloors = numFloors;
    }

    public void addDestination(int requestFloor, int destinationFloor) {
        lock.lock();
        try {
            if (!destinations.contains(requestFloor)) {
                destinations.add(requestFloor);
            }
            destinations.add(destinationFloor);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void operate() {
        while (true) {
            lock.lock();
            try {
                while (destinations.isEmpty()) {
                    condition.await();
                }
                processNextDestination();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }

    private void processNextDestination() {
        int nextFloor = destinations.poll();
        direction = Integer.compare(nextFloor, currentFloor);

        while (currentFloor != nextFloor) {
            try {
                Thread.sleep(1000); // Simulate travel time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            currentFloor += (direction > 0) ? 1 : -1;
            System.out.printf("Elevator %d at floor %d%n", id, currentFloor);

            if (destinations.contains(currentFloor)) {
                stopAtFloor(currentFloor);
            }
        }
        direction = 0;
    }

    private void stopAtFloor(int floor) {
        System.out.printf("Elevator %d stopping at floor %d%n", id, floor);
        destinations.remove(floor);
        passengers = Math.max(0, passengers - 1); // Passengers exit
    }

    public boolean canBoard() {
        lock.lock();
        try {
            return passengers < capacity;
        } finally {
            lock.unlock();
        }
    }

    public int getCurrentFloor() {
        lock.lock();
        try {
            return currentFloor;
        } finally {
            lock.unlock();
        }
    }

    public int getDirection() {
        lock.lock();
        try {
            return direction;
        } finally {
            lock.unlock();
        }
    }
}
