package org.example.behaviouraldp.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for (User user : users) {
            // Message should not be received by the sender
            if (user != sender) {
                user.receive(msg);
            }
        }
    }
}

