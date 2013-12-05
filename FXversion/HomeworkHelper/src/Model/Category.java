/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kylehodgkinson
 */
public class Category extends Observable implements Observer {

    ArrayList<Task> categoryTasks;
    String name;
    Double goal;
    Student student;
    TaskDB courseList;
    Integer numTasks;

    public Category(String name, Double goal, TaskDB courseList) {
        this.categoryTasks = new ArrayList<Task>();
        this.name = name;
        this.goal = goal;
        this.courseList = courseList;
        numTasks = 0;
    }

    public void addTask(Task task) {
        categoryTasks.add(task);
        courseList.addTask(task);
        numTasks++;
        setChanged();
        notifyObservers();
    }

    public ArrayList<Task> getCatTasks() {
        return categoryTasks;
    }

    public String getName() {
        return this.name;
    }

    public Double getGoal() {
        return this.goal;
    }

    public Integer getNumTasks() {
        return numTasks;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

    public Double getAverage() {

        Double total = new Double(0.0);
        Double temp = new Double(0.0);
        int graded = 0;

        for (int i = 0; i < this.getCatTasks().size(); i++) {

            temp = getCatTasks().get(i).getScore();

            System.out.println("task " + i + " score: " + temp);

            if (temp != null) {
                total += temp;
                graded++;
            }

        }

        if (graded > 0) {
            System.out.println(total);
            total = total / graded;
        } else {
            total = -1.0;
        }
        return total;
    }
}
