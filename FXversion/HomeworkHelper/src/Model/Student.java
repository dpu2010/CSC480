/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author kylehodgkinson
 */
public class Student extends Observable implements Observer {
    
    CourseDB courses;
    
    public Student() {
        courses = new CourseDB();
        courses.addObserver(this);
    }
    
    public CourseDB getCourseDataBase() {
        return courses;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
    
}
