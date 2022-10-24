package com.kodilla.spring.intro.shape;

public class Drawer {

    final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }
    /*public void doDrawing() {
        Shape figure;

        figure = new Circle();
        figure.draw();

        figure = new Triangle();
        figure.draw();
    }*/
}
