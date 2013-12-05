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
public class Category extends Observable implements Observer{
    
    ArrayList<Task> categoryTasks;
    String name;
    Double goal;
    Student student;
    TaskDB courseList;
    
    public Category(String name, Double goal, TaskDB courseList) {
        this.categoryTasks = new ArrayList<Task>();
        this.name = name;
        this.goal = goal;
        this.courseList = courseList; 
    }
    
    public void addTask(Task task) {
        categoryTasks.add(task);
        courseList.addTask(task);
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
    
    @Override 
     public String toString() {
        return this.name;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
