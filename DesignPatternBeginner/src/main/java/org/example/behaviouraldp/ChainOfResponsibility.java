package org.example.behaviouraldp;

import org.example.behaviouraldp.chainofresponsibility.ATMDispenser;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        ATMDispenser atmDispenser = new ATMDispenser();

        atmDispenser.dispenseCash(230);
        System.out.println();
        atmDispenser.dispenseCash(90);
        System.out.println();
        atmDispenser.dispenseCash(125);
        System.out.println();
        atmDispenser.dispenseCash(7);  // Invalid amount
    }
}
