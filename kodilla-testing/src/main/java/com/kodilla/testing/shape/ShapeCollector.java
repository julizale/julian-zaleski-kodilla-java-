package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    List<Shape> shapes = new ArrayList<>();

    public int getShapesQuantity() {
        return shapes.size();
    }

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapes.contains(shape)) {
            shapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        String result = "";
        for (Shape shape: shapes) {
            result += (shape.getShapeName() + " ");
        }
        return result;
    }

}
