package ru.zavoiko.live;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static ru.zavoiko.live.Config.*;

public class Window implements Runnable {

    private JFrame frame;
    private Box[][] boxes;

    @Override
    public void run() {
        initFrame();
        initBoxes();
        initTimer();
    }

    private void initFrame() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setSize(SIZE * WIDTH, SIZE * HEIGHT);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Let it be Live!");
    }

    private void initBoxes() {
        boxes = new Box[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                boxes[x][y] = new Box(x, y);
                frame.add(boxes[x][y]);
            }
        }
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int z = -1; z <= 1; z++) {
                    for (int i = -1; i <= 1; i++) {
                        if (z == 0 && i == 0)
                            continue;
                        boxes[x][y].getCell().addNear(boxes[(x + z + WIDTH) % WIDTH][(y + i + HEIGHT) % HEIGHT].getCell());
                    }
                }
            }
        }

        for (int x = 10; x < 15; x++) {
            boxes[x][10].getCell().setStatus(Status.LIVE);
            boxes[x][10].setColor();
        }
    }

    private void initTimer() {
        TimerListener timerListener = new TimerListener();
        Timer timer = new Timer(SLEEP, timerListener);
        timer.start();
    }

    private class TimerListener implements ActionListener {
        boolean flop = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            flop = !flop;
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    if (flop)
                        boxes[x][y].first();
                    else
                        boxes[x][y].second();
                }
            }
        }
    }
}
