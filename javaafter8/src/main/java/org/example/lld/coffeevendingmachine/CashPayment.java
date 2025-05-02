package org.example.lld.coffeevendingmachine;

public class CashPayment implements PaymentStrategy{

    private double cashProvided;

    public CashPayment(double cashProvided) {
        this.cashProvided = cashProvided;
    }
    @Override
    public boolean pay(double amount) {
        if (cashProvided >= amount) {
            double change = cashProvided - amount;
            System.out.printf("Payment successful. Change returned: %.2f%n", change);
            return true;
        } else {
            System.out.println("Insufficient cash provided.");
            return false;
        }
    }
}
