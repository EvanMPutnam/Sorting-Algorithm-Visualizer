package algorithms;

import data.Data;
import data.Line;

import java.awt.*;

public class BubbleSort extends Sort {

    public BubbleSort() {
        name = "Bubble Sort";
    }

    @Override
    public void sort(Data data, int delayTime) throws InterruptedException {
        int i;
        int j;
        for(i = 0; i < data.getSize(); i++) {
            for (j = 0; j < data.getSize() - i - 1; j++) {
                Line l1 = data.getAtIndex(j);
                Line l2 = data.getAtIndex(j + 1);
                if (stopSearch) {
                    return;
                }
                Thread.sleep(delayTime);
                if (l1.getValue() > l2.getValue()) {
                    l1.setColor(Color.YELLOW);
                    l2.setColor(Color.YELLOW);
                    data.swapIndexes(j, j + 1);
                    Thread.sleep(delayTime);
                    l1.setColor(Color.WHITE);
                    l2.setColor(Color.WHITE);
                }
            }
            Line l3 = data.getAtIndex(j);
            l3.setColor(Color.GREEN);
            Thread.sleep(delayTime);
        }

    }

}
