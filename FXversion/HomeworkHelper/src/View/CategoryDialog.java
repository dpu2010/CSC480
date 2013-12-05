/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Category;
import Model.Course;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class CategoryDialog {

    Stage stage;
    Course course;
    Course selectedCourse;

    public CategoryDialog(Stage stage, Course course) {
        this.stage = stage;
        this.course = course;
    }

    public void buildCategoryDialog() {

        VBox dialogLayout = new VBox();

        Label nameLabel = new Label("Category Name:");
        final TextField nameField = new TextField("New Category");
        Label targetLabel = new Label("Target Category Score:");
        final TextField targetField = new TextField("Target Score");
        Button createButton = new Button("Create");

        dialogLayout.getChildren().addAll(nameLabel, nameField, targetLabel, targetField, createButton);
        dialogLayout.setSpacing(10);

        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                Double score  = Double.valueOf(targetField.getText());
                String name = nameField.getText();
                Category newCat = new Category(name, score, course.getTaskDatabase());
                course.getCategoryDatabase().addCategory(newCat);
                stage.close();
            }
        });
        
        

        Scene dialogScene = new Scene(dialogLayout, 400, 250);

        this.stage.setTitle("New Category");
        this.stage.initStyle(StageStyle.DECORATED);
        this.stage.setScene(dialogScene);
        this.stage.show();
    }

}
