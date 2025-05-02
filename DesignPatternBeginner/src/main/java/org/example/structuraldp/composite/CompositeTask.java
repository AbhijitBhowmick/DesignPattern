package org.example.structuraldp.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task {
    private final List<Task> subtasks = new ArrayList<>();
    private String title;

    public CompositeTask(String title) {
        this.title = title;
    }

    public void add(Task task) {
        subtasks.add(task);
    }

    public void remove(Task task) {
        subtasks.remove(task);
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Composite Task: " + title);
        for (Task task : subtasks) {
            task.display();
        }
    }
}