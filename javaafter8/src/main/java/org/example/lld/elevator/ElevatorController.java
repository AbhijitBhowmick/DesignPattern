package org.example.lld.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ElevatorController{
    private final List<Elevator> elevators;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final int numFloors;

    public ElevatorController(int numElevators, int numFloors, int capacity) {
        this.numFloors = numFloors;
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i, capacity, numFloors));
        }
    }

    public void requestElevator(int requestFloor, int destinationFloor) {
        lock.writeLock().lock();
        try {
            Elevator bestElevator = null;
            int minScore = Integer.MAX_VALUE;

            for (Elevator elevator : elevators) {
                int score = calculateScore(elevator, requestFloor, destinationFloor);
                if (score < minScore && elevator.canBoard()) {
                    minScore = score;
                    bestElevator = elevator;
                }
            }

            if (bestElevator != null) {
                bestElevator.addDestination(requestFloor, destinationFloor);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private int calculateScore(Elevator elevator, int requestFloor, int destinationFloor) {
        int direction = Integer.compare(destinationFloor, requestFloor);
        int currentDirection = elevator.getDirection();

        if (currentDirection == 0) { // Idle
            return Math.abs(elevator.getCurrentFloor() - requestFloor);
        }

        if (currentDirection == direction) {
            if ((direction == 1 && requestFloor >= elevator.getCurrentFloor()) ||
                    (direction == -1 && requestFloor <= elevator.getCurrentFloor())) {
                return Math.abs(elevator.getCurrentFloor() - requestFloor);
            }
        }
        return Integer.MAX_VALUE;
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(elevators.size());
        for (Elevator elevator : elevators) {
            executor.execute(elevator::operate);
        }
    }
}
