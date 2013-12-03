/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author kylehodgkinson
 */
class Task {
    
    String name;
    //Date dueDate;
    String dueDate;
    Double score;
    Double duration;
    
    public Task(String name, String dueDate) {
        this.name = name;
        this.dueDate = dueDate;
    }
    
    
}
