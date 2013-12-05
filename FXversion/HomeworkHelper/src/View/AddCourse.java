/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author kylehodgkinson
 */
public class AddCourse extends VBox {

    Button addCourse;
    Button addCategory;
    Button addTask;
    Student student;

    public AddCourse(final Student student) {
        
        this.student = student;
        
        addCourse = new Button("Add New Course");
        addCourse.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = new Stage();
                CourseDialog newCourse = new CourseDialog(stage, student);
                newCourse.buildCourseDialog();
                stage.show();
            }
        });
        
        this.getChildren().addAll(addCourse);

        
    }

}
