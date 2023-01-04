package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class HomeworkQueue implements Observable {

    private final List<Observer> observers;
    private String traineeName;
    private final Deque<String> homeworks;

    public HomeworkQueue(String traineeName) {
        this.traineeName = traineeName;
        homeworks = new ArrayDeque<>();
        observers = new ArrayList<>();
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }
    public String getTraineeName() {
        return traineeName;
    }

    public Deque<String> getHomeworks() {
        return homeworks;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
