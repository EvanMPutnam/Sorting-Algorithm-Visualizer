package threading;

import algorithms.Sort;
import data.Data;

public class SortingRunnable implements Runnable {

    private Data data;
    private Sort sortingAlgo;

    private final int THREAD_DELAY = 200;

    public SortingRunnable(Data data, Sort sortingAlgo) {
        this.data = data;
        this.sortingAlgo = sortingAlgo;
    }

    @Override
    public void run() {
        try {
            sortingAlgo.sort(data, THREAD_DELAY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done with sorting");
    }

    public void setStopSearch() {
        this.sortingAlgo.setStopSearch(true);
    }
}
