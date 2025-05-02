package org.example.behaviouraldp;

import org.example.behaviouraldp.command.Broker;
import org.example.behaviouraldp.command.BuyStock;
import org.example.behaviouraldp.command.SellStock;
import org.example.behaviouraldp.command.Stock;

public class Command {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
