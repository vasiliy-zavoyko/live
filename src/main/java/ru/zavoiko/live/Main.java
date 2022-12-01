package ru.zavoiko.live;

import static javax.swing.SwingUtilities.invokeLater;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        invokeLater(window);
    }

}
