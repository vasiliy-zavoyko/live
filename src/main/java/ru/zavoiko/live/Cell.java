package ru.zavoiko.live;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private final List<Cell> cells;
    @Getter
    @Setter
    private Status status;

    public Cell() {
        status = Status.NONE;
        cells = new ArrayList<>();
    }

    public void addNear(Cell cell) {
        cells.add(cell);
    }

    public void firstStep() {
        final var around = countNearCells();
        status = status.firstStep(around);
    }


    public void secondStep() {
        status = status.secondStep();
    }

    private int countNearCells() {
        var i = 0;
        for (Cell cell : cells) {
            if (cell.getStatus().isCell()) {
                i++;
            }
        }
        return i;
    }


}
