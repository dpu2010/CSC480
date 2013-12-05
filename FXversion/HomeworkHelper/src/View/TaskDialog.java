/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Model.Category;
import Model.Course;
import Model.Task;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author kylehodgkinson
 */
public class TaskDialog {

    Course course; 
    Stage stage;
    Category selectedCat;
    
    public TaskDialog(Stage stage, Course course) {
        this.course = course;
        this.stage = stage;
    }
    
    public void buildTaskDialog() {
        VBox dialogLayout = new VBox();
                
        final Label nameLabel = new Label("Task Name:");
        final TextField nameField = new TextField("New Task");
        final Label catLabel = new Label("Select a Category:");
        final ComboBox catBox = new ComboBox(course.getCategoryDatabase().getObsCatList());
        catBox.valueProperty().addListener(
                new ChangeListener<Category>() {
                        @Override
                        public void changed(ObservableValue ov, Category old_val, Category new_val) {
                            selectedCat = new_val;
                    }
                });
        
        Button createButton = new Button("Create");
        
        createButton.setAlignment(Pos.BASELINE_CENTER);

        dialogLayout.getChildren().addAll(nameLabel, nameField, catLabel, catBox, createButton);
        dialogLayout.setSpacing(10);

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameField.getText();
                Task newTask = new Task(name, selectedCat);
                selectedCat.addTask(newTask);
                stage.close();
            }
        });

        Scene dialogScene = new Scene(dialogLayout, 400, 250);

        this.stage.setTitle("New Task");
        this.stage.initStyle(StageStyle.DECORATED);
        this.stage.setScene(dialogScene);
        this.stage.show();
    }
    
}
