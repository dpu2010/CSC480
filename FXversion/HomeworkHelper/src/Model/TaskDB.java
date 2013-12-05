/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author Tyler Kowallis
 * @author kylehodgkinson
 */
public class TaskDB extends Observable{
    
    List<Task> tasks;
    
    public TaskDB() {
        tasks = new ArrayList<>();
    }
    
    public List<Task> getTasks() {
        return tasks;
    }

    void addTask(Task task) {
        this.tasks.add(task);
        setChanged();
        notifyObservers();
    }
}
