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
class Course {
    
    CategoryDB categories;
    TaskDB tasks;
    String name;
    
    public Course(String name) {
        
        this.categories = new CategoryDB();
        this.tasks = new TaskDB();
        this.name = name;
        
    }
    
}
