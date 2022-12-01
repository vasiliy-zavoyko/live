package ru.zavoiko.live;

import lombok.Getter;

import javax.swing.*;


import static ru.zavoiko.live.Config.SIZE;

public class Box extends JPanel {

    @Getter
    private final Cell cell;

    public Box(int x, int y) {
        cell = new Cell();
        setBounds(x * SIZE, y * SIZE, SIZE, SIZE);
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
