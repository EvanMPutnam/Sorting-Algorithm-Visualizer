package algorithms;

import data.Data;
import data.Line;

import java.awt.*;

public class SelectionSort extends Sort{

    public SelectionSort() {
        name = "Selection Sort";
    }

    @Override
    public void sort(Data data, int delayTime) throws InterruptedException {
        int i;
        int j;
        int min;
        for (i = 0; i < data.getSize() - 1; i++) {
            min = i;
            for (j = i + 1; j < data.getSize(); j++) {
                Line l1 = data.getAtIndex(j);
                Line l2 = data.getAtIndex(min);
                l1.setColor(Color.YELLOW);
                if (l1.getValue() < l2.getValue()) {
                    min = j;
                    Thread.sleep(delayTime);
                    l1.setColor(Color.CYAN);
                    l2.setColor(Color.WHITE);
                } else {
                    Thread.sleep(delayTime);
                    l1.setColor(Color.WHITE);
                }
                if (stopSearch) {
                    return;
                }
            }
            Thread.sleep(delayTime);
            Line l3 = data.getAtIndex(min);
            data.swapIndexes(min, i);
            l3.setColor(Color.GREEN);
        }
        Line last = data.getAtIndex(data.getSize() - 1);
        last.setColor(Color.GREEN);
    }
}
