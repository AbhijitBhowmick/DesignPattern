package org.example.behaviouraldp.chainofresponsibility;

public class ATMDispenser {
    private DispenseChain chain;

    public ATMDispenser() {
        // Initialize the chain of responsibility
        this.chain = new Dollar50Dispenser();
        DispenseChain twentyDispenser = new Dollar20Dispenser();
        DispenseChain tenDispenser = new Dollar10Dispenser();

        // Set the chain of handlers
        chain.setNextChain(twentyDispenser);
        twentyDispenser.setNextChain(tenDispenser);
    }

    public void dispenseCash(int amount) {
        if (amount % 10 != 0) {
            System.out.println("Amount should be multiple of 10.");
            return;
        }
        chain.dispense(amount);
    }
}

