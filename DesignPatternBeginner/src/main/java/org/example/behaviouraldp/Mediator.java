package org.example.behaviouraldp;

import org.example.behaviouraldp.mediator.ChatMediator;
import org.example.behaviouraldp.mediator.ChatMediatorImpl;
import org.example.behaviouraldp.mediator.ChatUser;
import org.example.behaviouraldp.mediator.User;

public class Mediator {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User alice = new ChatUser(mediator, "Alice");
        User bob = new ChatUser(mediator, "Bob");
        User charlie = new ChatUser(mediator, "Charlie");

        mediator.addUser(alice);
        mediator.addUser(bob);
        mediator.addUser(charlie);

        alice.send("Hello everyone!");
        bob.send("Hi Alice!");
        charlie.send("Good morning!");
    }
}
