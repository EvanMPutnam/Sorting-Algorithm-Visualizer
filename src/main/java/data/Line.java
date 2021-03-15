package data;

import java.awt.*;

public class Line {

    private final int value;
    private Color color = Color.WHITE;

    public Line(int value) {
        this.value = value;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

}
