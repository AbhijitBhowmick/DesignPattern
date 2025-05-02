package org.example.behaviouraldp.chainofresponsibility;

public class Dollar20Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 20) {
            int count = amount / 20;
            int remainder = amount % 20;
            System.out.println("Dispensing " + count + " $20 bill(s)");
            if (remainder != 0 && nextChain != null) {
                nextChain.dispense(remainder);
            }
        } else if (nextChain != null) {
            nextChain.dispense(amount);
        }
    }
}