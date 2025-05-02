package org.example.behaviouraldp.chainofresponsibility;

public class Dollar10Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 10) {
            int count = amount / 10;
            int remainder = amount % 10;
            System.out.println("Dispensing " + count + " $10 bill(s)");
            if (remainder != 0) {
                System.out.println("Cannot dispense remaining amount: $" + remainder);
            }
        } else {
            System.out.println("Cannot dispense amount less than $10");
        }
    }
}