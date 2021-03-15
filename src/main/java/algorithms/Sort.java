package algorithms;

import data.Data;

public abstract class Sort {

    protected boolean stopSearch = false;
    protected String name = "Sort";

    abstract public void sort(Data data, int delayTime) throws InterruptedException;

    public void setStopSearch(boolean stopSearch) {
        this.stopSearch = stopSearch;
    }

    public String getName() {
        return name;
    }
}


