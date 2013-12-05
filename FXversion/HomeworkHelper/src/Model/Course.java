/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Tyler Kowallis
 * @author kylehodgkinson
 */
public class Course extends Observable implements Observer{
    
    CategoryDB categories;
    TaskDB tasks;
    String name;
    
    public Course(String name) {
        this.name = name;
        this.tasks = new TaskDB();
        tasks.addObserver(this);
        this.categories = new CategoryDB(tasks);
        categories.addObserver(this);
    }
    
    public CategoryDB getCategoryDatabase() {
        return categories;
    }
    
    public TaskDB getTaskDatabase() {
        return tasks;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
