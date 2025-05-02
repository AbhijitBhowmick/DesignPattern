package org.example.structuraldp;

import org.example.structuraldp.composite.CompositeTask;
import org.example.structuraldp.composite.SimpleTask;
import org.example.structuraldp.composite.Task;

public class Composite {
    public static void main(String[] args) {
        // Create simple tasks
        Task task1 = new SimpleTask("Design UI");
        Task task2 = new SimpleTask("Implement Backend");
        Task task3 = new SimpleTask("Write Tests");

        // Create a composite task
        CompositeTask project = new CompositeTask("New Website Project");

        // Add simple tasks to composite
        project.add(task1);
        project.add(task2);
        project.add(task3);

        // Create a sub-composite task
        CompositeTask deployment = new CompositeTask("Deployment");
        deployment.add(new SimpleTask("Setup Server"));
        deployment.add(new SimpleTask("Deploy Application"));

        // Add sub-composite to main composite
        project.add(deployment);

        // Display the whole project tasks hierarchy
        project.display();
    }
}
