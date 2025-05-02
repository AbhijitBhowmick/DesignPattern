package org.example.behaviouraldp.chainofresponsibility;

public class Dollar50Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(int amount) {
        if (amount >= 50) {
            int count = amount / 50;
            int remainder = amount % 50;
            System.out.println("Dispensing " + count + " $50 bill(s)");
            if (remainder != 0 && nextChain != null) {
                nextChain.dispense(remainder);
            }
        } else if (nextChain != null) {
            nextChain.dispense(amount);
        }
    }
}

