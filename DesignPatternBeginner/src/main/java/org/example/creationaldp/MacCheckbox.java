package org.example.creationaldp;

class MacCheckbox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("macOS-styled checkbox rendered");
    }
}