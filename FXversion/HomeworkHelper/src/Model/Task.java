/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 * @author Tyler Kowallis
 * @author kylehodgkinson
 */
public class Task extends Observable {

    String name;
    Double score;
    Double timeSpent;
    String suggestedTime;
    Category cat;

    public Task(String name, Category cat) {
        this.name = name;
        this.cat = cat;
        this.addObserver(cat);
        setSuggestedTime(cat);
    }

    public String getName() {
        return name;
    }

    public String getCatName() {
        return cat.getName();
    }

    public void setName(String n) {
        name = n;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double s) {
        score = s;
    }

    public String getSuggestedTime() {
        return suggestedTime;
    }

    public Double getTimeSpent() {
        return timeSpent;
    }

    public void setSuggestedTime(Category cat) {
        if (cat.getCatTasks().isEmpty()) {
            this.suggestedTime = "---";
        } else {
            TimeCalculator cal = new TimeCalculator(cat);
            this.suggestedTime = cal.calculateTime();
        }
    }

    public void setTimeSpent(Double d) {
        timeSpent = d;
    }
}
