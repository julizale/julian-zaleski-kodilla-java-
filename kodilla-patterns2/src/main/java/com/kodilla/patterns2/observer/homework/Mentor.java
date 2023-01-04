package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
        updateCount = 0;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println(name + ": New homework to check added by " + homeworkQueue.getTraineeName() +
                " (total homework in queue: " + homeworkQueue.getHomeworks().size());
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
