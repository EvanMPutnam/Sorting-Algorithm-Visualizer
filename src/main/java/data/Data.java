package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {

    private final List<Line> dataList;

    private final int MAX_NUMBER = 400;

    public Data() {
        this.dataList = new ArrayList<>();
    }

    public Line getAtIndex(int index) {
        return dataList.get(index);
    }

    public Integer getSize() {
        return dataList.size();
    }

    private void addLine(Line line) {
        dataList.add(line);
    }

    public List<Line> getDataList() {
        return dataList;
    }

    public void setAtIndex(int index, Line line) {
        synchronized (this) {
            dataList.set(index, line);
        }
    }

    public void  swapIndexes(int index1, int index2) {
        synchronized (this) {
            Line l1 = dataList.get(index1);
            Line l2 = dataList.get(index2);
            dataList.set(index1, l2);
            dataList.set(index2, l1);
        }
    }

    public static Data generateRandomData(int itemCount) {
        Data data = new Data();
        Random random = new Random();
        for (int i = 0; i < itemCount; i++) {
            data.addLine(new Line(random.nextInt(data.MAX_NUMBER)));
        }
        return data;
    }

    public boolean canRead() {
        synchronized (this) {
            return true;
        }
    }

}
