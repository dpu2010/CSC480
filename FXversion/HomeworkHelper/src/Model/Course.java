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
class Course {
    
    private CategoryDB categories;
    private TaskDB tasks;
    private String name;
    
    public Course(String name) {
        this.categories = new CategoryDB();
        this.tasks = new TaskDB();
        this.name = name;
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
    
    public void setName(String n) {
        name = n;
    }
}
