package org.example.structuraldp;

import org.example.structuraldp.flyweight.Tree;
import org.example.structuraldp.flyweight.TreeFactory;
import org.example.structuraldp.flyweight.TreeType;

import java.util.ArrayList;
import java.util.List;

public class Flyweight {
    private List<Tree> trees = new ArrayList<>();

    public static void main(String[] args) {
        Flyweight forest = new Flyweight();

        forest.plantTree(1, 2, "Oak", "Green", "Rough");
        forest.plantTree(3, 4, "Pine", "Dark Green", "Smooth");
        forest.plantTree(5, 6, "Oak", "Green", "Rough"); // Reuses existing TreeType

        forest.draw();
    }

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}
