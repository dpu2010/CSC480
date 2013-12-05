/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kylehodgkinson
 */
public class CourseDB extends Observable implements Observer{
    
    ArrayList<Course> courseDB;
    
    public CourseDB() {
        courseDB = new ArrayList<Course>();
    }
    
    public ObservableList<Course> getObsCourseList() {
        return FXCollections.observableArrayList(this.courseDB);
    }
    
    public ArrayList<Course> getCourseList() {
        return this.courseDB;
    }
    
    public void addCourse(Course course) {
        courseDB.add(course);
        course.addObserver(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
