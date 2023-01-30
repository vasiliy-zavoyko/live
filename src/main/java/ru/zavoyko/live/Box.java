package ru.zavoyko.live;

import lombok.Getter;

import javax.swing.*;

public class Box extends JPanel {

    @Getter
    private final Cell cell;

    public Box(int x, int y) {
        cell = new Cell();
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setBackground(cell.getStatus().getColor());
    }

    public void setColor() {
        setBackground(cell.getStatus().getColor());
    }

    public void first(){
        cell.firstStep();
        setColor();
    }

    public void second(){
        cell.secondStep();
        setColor();
    }

}
