package org.example.behaviouraldp.chainofresponsibility;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);

    void dispense(int amount);
}

