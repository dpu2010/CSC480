/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Course;
import Model.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author kylehodgkinson
 */
public class CourseDialog {

    Student student;
    Stage stage;

    public CourseDialog(Stage stage, Student student) {
        this.stage = stage;
        this.student = student;
    }

    public void buildCourseDialog() {
        
        System.out.println("Start of build Course Dialog");
        
        VBox dialogLayout = new VBox();

        Label nameLabel = new Label("Course Name:");
        final TextField nameField = new TextField("New Course");
        Button createButton = new Button("Create");

        dialogLayout.getChildren().addAll(nameLabel, nameField, createButton);
        dialogLayout.setSpacing(12);
        
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                student.getCourseDataBase().addCourse(new Course(nameField.getText()));
                stage.close();
            }
        });

        Scene dialogScene = new Scene(dialogLayout, 400, 250);

        this.stage.setTitle("New Course");
        this.stage.initStyle(StageStyle.DECORATED);
        this.stage.setScene(dialogScene);
        this.stage.show();
    }

}
