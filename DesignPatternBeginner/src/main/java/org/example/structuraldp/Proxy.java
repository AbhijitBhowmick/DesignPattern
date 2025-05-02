package org.example.structuraldp;

import org.example.structuraldp.proxy.Image;
import org.example.structuraldp.proxy.ProxyImage;

public class Proxy {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // Image will be loaded from disk only when display() is called the first time
        image.display();

        // Image will not be loaded again, as it is cached inside ProxyImage
        image.display();
    }
}
