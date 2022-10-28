package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(String taskClass) {
        return switch (taskClass) {
            case DRIVING -> new DrivingTask("Driving home", "home", "motorcycle");
            case SHOPPING -> new ShoppingTask("Shopping eggs", "eggs", 6);
            case PAINTING -> new PaintingTask("Painting wall", "white", "wall");
            default -> null;
        };
    }
}
