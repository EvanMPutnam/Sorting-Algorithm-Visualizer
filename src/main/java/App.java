import algorithms.BubbleSort;
import algorithms.MergeSort;
import algorithms.SelectionSort;
import algorithms.Sort;
import data.Data;
import data.Line;
import processing.core.PApplet;
import processing.event.KeyEvent;
import threading.SortingRunnable;

import java.awt.*;

public class App extends PApplet {

    private Data data;
    private Thread thread;
    private Sort currentAlgo;

    private final int MAX_WIDTH = 500;
    private final int MAX_HEIGHT = 500;

    private final int MAX_ELEMENTS = 100;

    // Key codes for user input.
    private int KEY_ONE = 49;
    private int KEY_TWO = 50;
    private int KEY_THREE = 51;
    private int KEY_SPACE = 32;

    public App() {
        data = Data.generateRandomData(MAX_ELEMENTS);
        currentAlgo = new MergeSort();
        thread = new Thread(new SortingRunnable(data, currentAlgo));
        thread.start();
    }

    @Override
    public void settings() {
        size(MAX_WIDTH, MAX_HEIGHT);
    }

    @Override
    public void draw() {
        background(0, 0, 0);
        drawLines();
        drawText();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KEY_ONE) {
            killSearch();
            initSearch(new MergeSort());
        } else if (keyCode == KEY_TWO) {
            killSearch();
            initSearch(new SelectionSort());
        } else if (keyCode == KEY_THREE) {
            killSearch();
            initSearch(new BubbleSort());
        } else if (keyCode == KEY_SPACE) {
            killSearch();
            initSearch();
        }
    }

    private void initSearch(Sort algo) {
        this.currentAlgo = algo;
        data = Data.generateRandomData(MAX_ELEMENTS);
        thread = new Thread(new SortingRunnable(data, currentAlgo));
        thread.start();
    }

    private void initSearch() {
        data = Data.generateRandomData(MAX_ELEMENTS);
        thread = new Thread(new SortingRunnable(data, currentAlgo));
        thread.start();
    }

    private void killSearch() {
        currentAlgo.setStopSearch(true);
        while (thread.isAlive()) {}
        System.out.println("KILLED SEARCH");
        currentAlgo.setStopSearch(false);
    }

    private void drawLines() {
        int count = 0;
        int spacing = MAX_HEIGHT / data.getSize();
        if (data.canRead()) {
            for (Line line : data.getDataList()) {
                Color c = line.getColor();
                fill(c.getRed(), c.getGreen(), c.getBlue());
                rect(count * spacing, 0, spacing, line.getValue());
                count += 1;
            }
        }
    }

    private void drawText() {
        text(currentAlgo.getName(), MAX_WIDTH / 2, MAX_HEIGHT - 50);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"SortingAlgos"};
        App sortingApp = new App();
        PApplet.runSketch(processingArgs, sortingApp);
    }
}
