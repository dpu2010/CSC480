/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 * @author Tyler Kowallis
 * @author kylehodgkinson
 */
class Task {
    
    String name;
    //Date dueDate;
    String dueDate;
    Double score;
    Double duration;
    
    public Task() {
        name = null;
        dueDate = null;
    }
    
    public Task(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        name = n;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(String d) {
        dueDate = d;
    }
    
    public Double getScore() {
        return score;
    }
    
    public void setScore(Double s) {
        score = s;
    }
    
    public Double getDuration() {
        return duration;
    }
    
    public void setDuration(Double d) {
        duration = d;
    }
}
