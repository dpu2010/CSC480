/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;

/**
 *
 * @author kylehodgkinson
 */
class Category {
    
    ArrayList<Task> categoryTasks;
    String name;
    Double goal;
    
    public Category(String name, Double goal) {
        this.categoryTasks = new ArrayList<Task>();
        this.name = name;
        this.goal = goal;
    }
    
}
