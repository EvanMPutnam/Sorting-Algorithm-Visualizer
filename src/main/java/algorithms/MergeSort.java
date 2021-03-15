package algorithms;

import data.Data;
import data.Line;

import java.awt.*;

public class MergeSort extends Sort {

    public MergeSort() {
        name = "Merge Sort";
    }

    @Override
    public void sort(Data data, int delayTime) throws InterruptedException {
        mergeSort(data, 0, data.getSize() - 1, delayTime);
        if (stopSearch) {
            return;
        }
        // Set finished state.
        for (Line line : data.getDataList()) {
            line.setColor(Color.GREEN);
        }
    }

    private void mergeSort(Data data, int start, int end, int delayTime) throws InterruptedException {
        if (start < end) {
            int middle = (start + end) / 2;

            // Merge sort left half.
            mergeSort(data, start, middle, delayTime);
            if (stopSearch) {
                return;
            }
            Thread.sleep(delayTime);

            // Merge sort right half.
            mergeSort(data, middle + 1, end, delayTime);
            if (stopSearch) {
                return;
            }
            Thread.sleep(delayTime);

            // Merge the halves.
            merge(data, start, middle, end, delayTime);
            if (stopSearch) {
                return;
            }
            Thread.sleep(delayTime);
        }
    }

    private void merge(Data data, int start, int mid, int end, int delayTime) throws InterruptedException {
        Line[] tempLines = new Line[end - start + 1];

        for (int i = start; i < end; i++) {
            Line l = data.getAtIndex(i);
            l.setColor(Color.YELLOW);
        }

        if (stopSearch) {
            return;
        }
        Thread.sleep(delayTime);

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            Line l = data.getAtIndex(i);
            Line l2 = data.getAtIndex(j);
            if (l.getValue() <= l2.getValue()) {
                tempLines[k] = l;
                k += 1;
                i += 1;
            } else {
                tempLines[k] = l2;
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            Line l = data.getAtIndex(i);
            tempLines[k] = l;
            k += 1;
            i += 1;
        }

        while (j <= end) {
            Line l = data.getAtIndex(j);
            tempLines[k] = l;
            k += 1;
            j += 1;
        }

        for (i = start; i <= end; i += 1) {
            Line l = tempLines[i-start];
            data.setAtIndex(i, l);
        }

        if (stopSearch) {
            return;
        }
        Thread.sleep(delayTime);
        for (int t = start; t <= end; t++) {
            Line l = data.getAtIndex(t);
            l.setColor(Color.WHITE);
        }
        Thread.sleep(delayTime);
    }

}
